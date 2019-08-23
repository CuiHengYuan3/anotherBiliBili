package com.example.anotherbilibili.ui

import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.core.view.ViewCompat.animate
import android.R.attr.rotation
import android.R.attr.scaleX
import android.R.attr.scaleY
import android.animation.Animator
import androidx.core.view.ViewCompat.setRotation
import androidx.core.view.ViewCompat.setScaleY
import androidx.core.view.ViewCompat.setScaleX
import com.lxj.xpopup.animator.PopupAnimator


internal class ScreenShotAnimator : PopupAnimator() {
    override fun initAnimator() {
        targetView.scaleX = 0f
        targetView.scaleY = 0f
        targetView.alpha = 0f
        targetView.rotation = 360f
    }

    override fun animateShow() {
        targetView.animate().rotation(0f).scaleX(1f).scaleY(1f).alpha(1f).setInterpolator(FastOutSlowInInterpolator())
            .setDuration(700).start()
        targetView.animate().setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                animateDismiss()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
    }

    override fun animateDismiss() {
        targetView.animate().rotation(360f).scaleX(0f).scaleY(0f).alpha(0f).setInterpolator(FastOutSlowInInterpolator())
            .setDuration(500).setStartDelay(1000).start()
    }
}