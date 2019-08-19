package com.example.anotherbilibili.ui.activity

import android.annotation.TargetApi
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.transition.Transition
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
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.contract.VideoConstract
import com.example.anotherbilibili.mvp.presenter.VideoPresenter
import com.example.anotherbilibili.transferToExtractBean
import kotlinx.android.synthetic.main.content_video_acitvity.*
import com.shuyu.gsyvideoplayer.listener.LockClickListener
import com.shuyu.gsyvideoplayer.utils.Debuger
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.GSYVideoManager


class VideoAcitvity : baseActivity(), VideoConstract.view {

    companion object {
        const val TRANSITION = "TRANSITION"
        const val TRANSITIONVIEW = "TRANSITIONAL"
    }

    private val videoPresenter by lazy {
        VideoPresenter()
    }
    private var transition: Transition? = null
    private var orientationUtils: OrientationUtils? = null
    private var isPlay = false
    private var isPause = false
    override fun getLayoutId(): Int = R.layout.activity_video_acitvity
//    private var recommenddata: RecommendBean.Data? = null

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

    override fun initView() {
        videoPresenter.bindView(this)
        initVideo()
        initTransition()
        setStatuas()
    }


    override fun setVideoData(data: ExtractBean) {
        mVideoView.setUp(data.videoUrl, true, data.videoName)
        //开始自动播放
        mVideoView.startPlayLogic()



    }


    override fun showIsLoading() {
    }

    override fun removeLoading() {
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


    override fun finalPrepare() {

    }
    //https://github.com/CarGuo/GSYVideoPlayer/blob/master/gsyVideoPlayer-java/src/main/java/com/shuyu/gsyvideoplayer/video/base/GSYVideoControlView.java
    //    //自定义布局


}
