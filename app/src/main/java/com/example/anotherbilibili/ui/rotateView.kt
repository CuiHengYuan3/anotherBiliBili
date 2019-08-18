package com.example.anotherbilibili.ui

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class rotateView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : ImageView(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)


    init {

        val objectAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f)
        objectAnimator.repeatMode = ValueAnimator.RESTART
        objectAnimator.repeatCount = ValueAnimator.INFINITE
        objectAnimator.start()
    }




}