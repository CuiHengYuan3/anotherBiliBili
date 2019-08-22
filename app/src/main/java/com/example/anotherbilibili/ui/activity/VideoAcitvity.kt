package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.Color
import android.media.MediaMetadataRetriever
import android.os.Build
import android.os.Bundle
import android.transition.Transition
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.anotherbilibili.R
import com.shuyu.gsyvideoplayer.GSYBaseActivityDetail
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer

import kotlinx.android.synthetic.main.activity_video_acitvity.*
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import cn.leancloud.AVObject
import com.bumptech.glide.Glide
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.event.AVobectEvent
import com.example.anotherbilibili.event.SendDanmuEvent
import com.example.anotherbilibili.mvp.Bean.*
import com.example.anotherbilibili.mvp.contract.VideoConstract
import com.example.anotherbilibili.mvp.presenter.VideoPresenter
import com.example.anotherbilibili.transferToExtractBean
import com.example.anotherbilibili.ui.CommentDialogView
import com.example.anotherbilibili.ui.adapter.CommentAdapter
import com.example.anotherbilibili.ui.myVideoView
import com.example.anotherbilibili.utils.AVobjectUtils
import com.example.anotherbilibili.utils.Dip2pxUtil
import com.example.anotherbilibili.utils.KeybordUtils
import com.example.anotherbilibili.utils.KeybordUtils.openKeyBord
import com.lxj.xpopup.XPopup
import kotlinx.android.synthetic.main.content_video_acitvity.*
import com.shuyu.gsyvideoplayer.listener.LockClickListener
import com.shuyu.gsyvideoplayer.utils.Debuger
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.GSYVideoManager
import com.shuyu.gsyvideoplayer.listener.GSYVideoShotListener
import kotlinx.android.synthetic.main.video_layout_standard_my.*
import master.flame.danmaku.controller.DrawHandler
import master.flame.danmaku.danmaku.model.BaseDanmaku
import master.flame.danmaku.danmaku.model.DanmakuTimer
import master.flame.danmaku.danmaku.model.IDanmakus
import master.flame.danmaku.danmaku.model.IDisplayer
import master.flame.danmaku.danmaku.model.android.DanmakuContext
import master.flame.danmaku.danmaku.model.android.Danmakus
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.image
import org.jetbrains.anko.toast


@SuppressLint("WrongConstant")
class VideoAcitvity : baseActivity(), VideoConstract.view {

    companion object {
        const val TRANSITION = "TRANSITION"
        const val TRANSITIONVIEW = "TRANSITIONAL"
    }


    private val videoPresenter by lazy {
        VideoPresenter()
    }
    private val linearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
    private var commentDialogView: CommentDialogView? = null
    private var commentAdapter: CommentAdapter? = null
    private var transition: Transition? = null
    private var orientationUtils: OrientationUtils? = null
    private var isShowDanmu = true
    private var isPlay = false
    private var isPause = false
    private var isDataFromAV = false//此视频的数据是否为云端加载
    private var avObject: AVObject? = null//如果云端有数据就把传回的AVobject赋值给此变量，以用作更新，不再创建一个新对象
    private var danmukuContext = DanmakuContext.create()


    private var parser: BaseDanmakuParser = object : BaseDanmakuParser() {
        override fun parse(): IDanmakus {
            return Danmakus()
        }

    }


    override fun getLayoutId(): Int = R.layout.activity_video_acitvity

    private var extraData: ExtractBean? = null
    override fun initData() {
        //有两个intent都可以到这个activity，都转化为extractBean,下面两种情况的任意一种
        val recommenddata = intent.getSerializableExtra("recommendData") as NewRecommendBean.Result?
        recommenddata?.let {
            extraData = it.transferToExtractBean()
        }
        val catalogDetailData =
            intent.getSerializableExtra("catalogDetailData") as CatalogDetailBean.Item.Data.Content.Data?
        catalogDetailData?.let {
            extraData = it.transferToExtractBean()
        }


        Log.d("ccc", (extraData?.commendList == null).toString())

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        videoPresenter.bindView(this)
        setUpView()
        extraData?.videoUrl?.let { videoPresenter.getVideoDataFromAV(it) }  //尝试从云端加载
        initDanmu()
        initVideo()
        initTransition()
        setStatuas()
        initListener()

    }

    private fun setUpView() {
        tv_video_titil.text = extraData?.videoName ?: "无名之物"
        tv_user_id.text = extraData?.autherName ?: "无名之人"
        tv_publishTime.text=extraData?.publishTime?:"2019-08-21 11:11:11"
        Glide.with(this).load(extraData?.autherImaeg).into(im_user)
        commentDialogView = CommentDialogView(this)
    }

    override fun setDefaultData() {
        tv_like.text = 0.toString()//没有获取到视频数据，设置默认值
        extraData?.loveNumber = 0//改变bean类数据，方便传到云端。
        tv_collect.text = 0.toString()
        extraData?.collectNumber = 0
        isDataFromAV = false

    }

    //此方法如果被调用即云端有此视频的数据，
    // 那么如果用户点击喜欢，收藏，评论的时候就不是上传数据而是更新原有数据
    override fun setRefreshedData(data: AVObject?) {
        isDataFromAV = true //数据从云端加载
        avObject = data//赋值

        im_nothing.visibility = View.GONE

        val loveNumber = data?.get("loveNumber") as Int
        tv_like.text = (loveNumber).toString()
        extraData?.loveNumber = loveNumber

        val collectNumber = data.get("collectNumber") as Int
        tv_collect.text = (collectNumber).toString()
        extraData?.collectNumber = collectNumber

        //获取评论
        val commendList = data.get("commendList")
        extraData?.commendList =
            (commendList as MutableList<HashMap<String, String>>?)?.map { item -> AVobjectUtils.hashMapToBean(item) } as MutableList<CommendBean>?
        extraData?.commendList?.let {
            commentAdapter = CommentAdapter(this, it as ArrayList<CommendBean>, R.layout.item_comment)
            re_comment.adapter = commentAdapter
            re_comment.layoutManager = linearLayoutManager
        }


    }


    override fun setVideoData(data: ExtractBean) {
        mVideoView.setUp(data.videoUrl, true, data.videoName)
        //开始自动播放
        mVideoView.startPlayLogic()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initListener() {
        im_like.setOnClickListener {
            im_like.image = getDrawable(R.mipmap.like_ok)
            tv_like.text = (tv_like.text.toString().toInt() + 1).toString()
            extraData?.loveNumber = extraData?.loveNumber?.plus(1)
            refreshData() //更新云端数据
            isDataFromAV = true
        }

        im_collecct.setOnClickListener {
            im_collecct.image = getDrawable(R.mipmap.collect_ok)
            tv_collect.text = (tv_collect.text.toString().toInt() + 1).toString()
            extraData?.collectNumber = extraData?.collectNumber?.plus(1)
            refreshData()
            isDataFromAV = true
        }

        commentDialogView?.sendCommentListener = {
            val currentUser = AVobjectUtils.getCurentUser(this)
            val commendBean = currentUser?.let { avUer ->
                return@let CommendBean(null, avUer.username, it)
            }
            //如果为空就不加入
            commendBean?.let { commend -> extraData?.commendList?.add(commend) }
            if (commentAdapter == null) {
                commentAdapter =
                    CommentAdapter(this, extraData?.commendList as ArrayList<CommendBean>, R.layout.item_comment)
                re_comment.layoutManager = linearLayoutManager
                re_comment.adapter = commentAdapter
                im_nothing.visibility = View.GONE
            } else {
                commentAdapter!!.notifyDataSetChanged()
            }
            refreshData()
            isDataFromAV = true
        }


        fab_video.setOnClickListener {
            XPopup.Builder(this)
                .asCustom(commentDialogView)
                .show()
            openKeyBord(this)

        }


    }


    //汇集刷云端新逻辑
    private fun refreshData() {
        if (isDataFromAV) {
            extraData?.let { it1 -> videoPresenter.reFreshAVdata(avObject, it1) }
        } else {
            extraData?.let { videoPresenter.pushToAV(it) }
        }


    }


    override fun showIsLoading() {


    }

    override fun removeLoading() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun reciveAvObect(avobectEvent: AVobectEvent) {
        avObject = avobectEvent.avObject
    }


    @Subscribe(threadMode = ThreadMode.MAIN)

    fun getDnamu(sendDanmuEvent: SendDanmuEvent) {
        extraData?.danmuList?.add(sendDanmuEvent.text)
        refreshData()
        addDanmaku(sendDanmuEvent.text, true)
        isDataFromAV = true
//        val a = MediaMetadataRetriever()
//        a.setDataSource(extraData?.videoUrl, HashMap<String, String>())
//        a.getFrameAtTime(2, MediaMetadataRetriever.OPTION_CLOSEST)
//        mVideoView.taskShotPic {
//
//            Log.d("vvv", it.toString())
//
//        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addTransitionListener() {
        transition = window.sharedElementEnterTransition
        transition?.addListener(object : Transition.TransitionListener {

            override fun onTransitionResume(transition: Transition?) {}
            override fun onTransitionPause(transition: Transition?) {}
            override fun onTransitionCancel(transition: Transition?) {}
            override fun onTransitionStart(transition: Transition?) {}

            override fun onTransitionEnd(p0: Transition?) {
                extraData?.let { videoPresenter.loadVideodata(it) }
                transition?.removeListener(this)
            }

        })
    }


    fun initDanmu() {
        danmu.enableDanmakuDrawingCache(true)
        danmu.setCallback(object : DrawHandler.Callback {
            override fun drawingFinished() {

            }

            override fun danmakuShown(danmaku: BaseDanmaku?) {

            }

            override fun prepared() {
                isShowDanmu = true
                danmu.start()
                extraData?.danmuList?.let {
                    for (i in it) {
                        addDanmaku(i, false)
                    }
                }

            }

            override fun updateTimer(timer: DanmakuTimer?) {

            }

        })

        danmukuContext!!.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN, 3F)//设置描边样式
            .setDuplicateMergingEnabled(false)//是否启用合并重复弹幕
            .setScrollSpeedFactor(1.2f) //设置弹幕滚动速度系数,只对滚动弹幕有效
            .setScaleTextSize(1.2f)//设置字体缩放
        danmu.prepare(parser, danmukuContext)

    }

    private fun addDanmaku(content: String, withBorder: Boolean = false) {
        val danmaku = danmukuContext.mDanmakuFactory.createDanmaku(BaseDanmaku.TYPE_SCROLL_RL, danmukuContext)
        danmaku?.text = content
        danmaku?.padding = 5
        danmaku?.priority = 1
        danmaku?.textSize = Dip2pxUtil.sp2px(this, 30.0F)
        danmaku?.textColor = Color.WHITE
        danmaku?.time = danmu.currentTime + 1200
        if (withBorder) {
            danmaku?.borderColor = Color.GREEN
        }
        danmu.addDanmaku(danmaku)
    }


    fun initVideo() {
//外部辅助的旋转，帮助全屏
        orientationUtils = OrientationUtils(this, mVideoView)
//初始化不打开外部的旋转
        orientationUtils!!.setEnable(false)

        val gsyVideoOption = GSYVideoOptionBuilder()
        gsyVideoOption
            //.setThumbImageView()
            .setIsTouchWiget(true)
            .setRotateViewAuto(false)
            .setLockLand(false)
            .setAutoFullWithSize(true)
            .setShowFullAnimation(false)
            .setNeedLockFull(true)
            //.setUrl(url)
            .setCacheWithPlay(false)
            .setVideoAllCallBack(object : GSYSampleCallBack() {
                override fun onPrepared(url: String?, vararg objects: Any) {
                    super.onPrepared(url, *objects)
                    //开始播放了才能旋转和全屏
                    orientationUtils!!.setEnable(true)
                    isPlay = true
                }

                override fun onQuitFullscreen(url: String?, vararg objects: Any) {
                    super.onQuitFullscreen(url, *objects)
                    Debuger.printfError("***** onQuitFullscreen **** " + objects!![0])//title
                    Debuger.printfError("***** onQuitFullscreen **** " + objects!![1])//当前非全屏player
                    orientationUtils!!.backToProtVideo()
                }
            }).setLockClickListener { view, lock ->
                orientationUtils!!.isEnable = !lock
            }.build(mVideoView)

        mVideoView.getFullscreenButton().setOnClickListener {
            //直接横屏
            orientationUtils!!.resolveByClick()

            //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
            mVideoView.startWindowFullscreen(this@VideoAcitvity, true, true)
        }

    }


    private fun initTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition()
            ViewCompat.setTransitionName(mVideoView, TRANSITIONVIEW)
            addTransitionListener()
            startPostponedEnterTransition()
        } else {
            extraData?.let { videoPresenter.loadVideodata(it) }
        }
    }

    private fun setStatuas() {
        if (Build.VERSION.SDK_INT >= 21) {
            val window = getWindow();
            window.setStatusBarColor(Color.BLACK);
        }

    }

    override fun onBackPressed() {
        orientationUtils?.backToProtVideo()
        if (GSYVideoManager.backFromWindowFull(this)) {
            return
        }
        super.onBackPressed()
    }


    override fun onPause() {
        mVideoView.currentPlayer.onVideoPause()
        super.onPause()
        if (danmu != null && danmu.isPrepared()) {
            danmu.pause()
            isPause = true
        }
    }

    override fun onResume() {
        mVideoView.getCurrentPlayer().onVideoResume(false)
        super.onResume()
        danmu.resume()
        if (danmu != null && danmu.isPrepared() && danmu.isPaused()) {
            danmu.resume()
            isPause = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (danmu != null) {
            danmu.release()
        }

        EventBus.getDefault().unregister(this)
        if (isPlay) {
            mVideoView.getCurrentPlayer().release()
        }
        orientationUtils?.releaseListener()
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            mVideoView.onConfigurationChanged(this, newConfig, orientationUtils, true, true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
    }


    override fun finalPrepare() {

    }


}
