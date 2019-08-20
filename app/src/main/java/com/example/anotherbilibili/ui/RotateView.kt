package com.example.anotherbilibili.ui

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import android.widget.ImageView

class RotateView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : ImageView(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    init {

        val objectAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f)
        objectAnimator.duration = 1000
        objectAnimator.interpolator= LinearInterpolator()
        objectAnimator.repeatMode = ValueAnimator.RESTART
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.start()
    }



}