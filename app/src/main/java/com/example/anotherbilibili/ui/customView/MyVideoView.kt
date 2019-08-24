package com.example.anotherbilibili.ui.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.anotherbilibili.R
import com.example.anotherbilibili.event.ScreenShotEvent
import com.example.anotherbilibili.event.SendDanmuEvent
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import org.greenrobot.eventbus.EventBus

/**
 * 视频播放的view,继承GSYVideoPlayer，实现一部分自定义的ui和逻辑
 */
class MyVideoView(context: Context, attrs: AttributeSet?) :
    StandardGSYVideoPlayer(context, attrs) {
    constructor(context: Context) : this(context, null)


    var danmuedit: AppCompatEditText? = null
    var sendDanmuButton: AppCompatButton? = null
    var screenShotButton: AppCompatButton? = null
    var sendDanmuListener: ((tag: String) -> Unit)? = null
        set(value) {
            field = value
        }


    override fun init(context: Context?) {
        super.init(context)
        danmuedit = findViewById<AppCompatEditText>(R.id.ed_danmu)
        sendDanmuButton = findViewById<AppCompatButton>(R.id.btn_send_danmu)
        screenShotButton = findViewById<AppCompatButton>(R.id.btn_cut)
        sendDanmuButton!!.setOnClickListener {

            EventBus.getDefault().post(SendDanmuEvent(danmuedit!!.text.toString()))

        }
        screenShotButton?.setOnClickListener {

            EventBus.getDefault().post(ScreenShotEvent())

        }

    }



    override fun getLayoutId(): Int {
        return R.layout.video_layout_standard_my
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

    override fun onClickUiToggle() {
        super.onClickUiToggle()
        if (mIfCurrentIsFullscreen) {
            findViewById<LinearLayout>(R.id.ll_danmu_contanier).visibility = View.VISIBLE
        } else {
            findViewById<LinearLayout>(R.id.ll_danmu_contanier).visibility = View.GONE
        }


    }


}
