package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.res.Configuration
import android.graphics.Color
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
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.event.AVobectEvent
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.contract.VideoConstract
import com.example.anotherbilibili.mvp.presenter.VideoPresenter
import com.example.anotherbilibili.transferToExtractBean
import com.example.anotherbilibili.ui.adapter.CommentAdapter
import kotlinx.android.synthetic.main.content_video_acitvity.*
import com.shuyu.gsyvideoplayer.listener.LockClickListener
import com.shuyu.gsyvideoplayer.utils.Debuger
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.GSYVideoManager
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.image


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
    private var commentAdapter: CommentAdapter? = null
    private var transition: Transition? = null
    private var orientationUtils: OrientationUtils? = null
    private var isPlay = false
    private var isPause = false
    private var isDataFromAV = false//此视频的数据是否为云端加载
    private var avObject: AVObject? = null//如果云端有数据就把传回的AVobject赋值给此变量，以用作更新，不再创建一个新对象

    override fun getLayoutId(): Int = R.layout.activity_video_acitvity

    private var extraData: ExtractBean? = null
    override fun initData() {
        //有两个intent都可以到这个activity，都转化为extractBean,下面两种情况的任意一种
        val recommenddata = intent.getSerializableExtra("recommendData") as RecommendBean.Data?
        recommenddata?.let {
            extraData = it.transferToExtractBean()
        }
        val catalogDetailData =
            intent.getSerializableExtra("catalogDetailData") as CatalogDetailBean.Item.Data.Content.Data?
        catalogDetailData?.let {
            extraData = it.transferToExtractBean()
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        videoPresenter.bindView(this)
        extraData?.videoUrl?.let { videoPresenter.getVideoDataFromAV(it) }  //尝试从云端加载
        initVideo()
        initTransition()
        setStatuas()
        initListener()
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

        var loveNumber = data?.get("loveNumber") as Int
        tv_like.text = (loveNumber).toString()
        extraData?.loveNumber = loveNumber

        val collectNumber = data?.get("collectNumber") as Int
        tv_collect.text = (collectNumber).toString()
        extraData?.collectNumber = collectNumber

        val commendList = data?.get("commendList") as MutableList<CommendBean>?
        extraData?.commendList = commendList
        commendList?.let {
            commentAdapter = CommentAdapter(this, it as ArrayList<CommendBean?>, R.layout.item_comment)
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

    }


    //汇集刷云端新逻辑
    private fun refreshData() {
        if (isDataFromAV) {
            Log.d("gfg", avObject.toString())
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
    fun XXX(avobectEvent: AVobectEvent) {
        avObject = avobectEvent.avObject

        Log.d("gfg", avObject.toString())


    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun addTransitionListener() {
        transition = window.sharedElementEnterTransition
        transition?.addListener(object : Transition.TransitionListener {
            override fun onTransitionResume(p0: Transition?) {

            }

            override fun onTransitionPause(p0: Transition?) {
            }

            override fun onTransitionCancel(p0: Transition?) {
            }

            override fun onTransitionStart(p0: Transition?) {


            }

            override fun onTransitionEnd(p0: Transition?) {
                extraData?.let { videoPresenter.loadVideodata(it) }
                transition?.removeListener(this)
            }

        })
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
        isPause = true
    }

    override fun onResume() {
        mVideoView.getCurrentPlayer().onVideoResume(false)
        super.onResume()
        isPause = false
    }

    override fun onDestroy() {
        super.onDestroy()
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
