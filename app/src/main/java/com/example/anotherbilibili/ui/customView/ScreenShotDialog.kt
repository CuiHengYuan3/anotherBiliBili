package com.example.anotherbilibili.ui.customView

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.widget.AppCompatImageView
import com.example.anotherbilibili.R
import com.lxj.xpopup.core.PositionPopupView

@SuppressLint("ViewConstructor")
class ScreenShotDialog(context: Context, var bitmap: Bitmap) : PositionPopupView(context) {


    override fun getImplLayoutId(): Int {

        return R.layout.dialog_screen_shot

    }

    override fun onCreate() {
        super.onCreate()
        val screeShotImage = findViewById<AppCompatImageView>(R.id.im_scree_shot)
        screeShotImage.setImageBitmap(bitmap)

    }

}