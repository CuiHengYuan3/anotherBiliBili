package com.example.anotherbilibili.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : baseActivity() {

    override fun initData() {

    }

    override fun initView() {
        val objectAnimator = ObjectAnimator.ofFloat(im_splash, "alpha", 0.4f, 1f)
        with(objectAnimator)
        {
            duration = 2000
            objectAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) { }

                override fun onAnimationEnd(animation: Animator?) {

                    startActivity<VideoAcitvity>()
                finish()
                }

                override fun onAnimationCancel(animation: Animator?) { }

                override fun onAnimationStart(animation: Animator?) { }

            })

            start()

        }

    }

    override fun finalPrepare() {


    }


    override fun getLayoutId(): Int = R.layout.activity_splash

}



