package com.example.anotherbilibili.ui.activity

import android.os.Build
import android.os.Bundle
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
import kotlinx.android.synthetic.main.content_video_acitvity.*


class VideoAcitvity : GSYBaseActivityDetail<StandardGSYVideoPlayer>() {
    var detailPlayer:StandardGSYVideoPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.anotherbilibili.R.layout.activity_video_acitvity)

       detailPlayer = mVideoView as StandardGSYVideoPlayer
        //增加title
        detailPlayer!!.getTitleTextView().setVisibility(View.GONE)
        detailPlayer!!.getBackButton().setVisibility(View.GONE)

        initVideoBuilderMode()

    }

    override fun getGSYVideoPlayer(): StandardGSYVideoPlayer? {
        return detailPlayer
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun getGSYVideoOptionBuilder(): GSYVideoOptionBuilder {
        //内置封面可参考SampleCoverVideo
        val imageView = ImageView(this)
     imageView.setImageDrawable(getDrawable(R.drawable.abc_btn_check_material))
      //  loadCover(imageView, url)
        return GSYVideoOptionBuilder()
            .setThumbImageView(imageView)
            .setUrl("http://wvideo.spriteapp.cn/video/2019/0217/207a2006-32a4-11e9-86d3-d4ae5296039d_wpd.mp4")
            .setCacheWithPlay(true)
            .setVideoTitle(" ")
            .setIsTouchWiget(true)
            .setRotateViewAuto(false)
            .setLockLand(false)
            .setShowFullAnimation(false)
            .setNeedLockFull(true)
            .setSeekRatio(1f)
    }

    override fun clickForFullScreen() {

    }


    /**
     * 是否启动旋转横屏，true表示启动
     */
    override fun getDetailOrientationRotateAuto(): Boolean {
        return true
    }



}
