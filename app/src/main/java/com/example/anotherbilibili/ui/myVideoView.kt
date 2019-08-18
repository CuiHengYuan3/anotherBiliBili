package com.example.anotherbilibili.ui

import android.content.Context
import android.util.AttributeSet
import com.example.anotherbilibili.R
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer






class myVideoView(context: Context, attrs: AttributeSet?) :

    StandardGSYVideoPlayer(context, attrs) {
    constructor(context: Context) : this(context, null)

    override fun getLayoutId(): Int {
        return  R.layout.video_layout_standard_my
    }
    override fun getProgressDialogLayoutId(): Int {
        return R.layout.video_progress_ui_dialog
    }
    override fun getVolumeLayoutId(): Int {
        return R.layout.video_volume
    }
    override fun getBrightnessLayoutId(): Int {
        return R.layout.video_bright
    }


}
