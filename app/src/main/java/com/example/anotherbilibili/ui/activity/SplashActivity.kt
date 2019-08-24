package com.example.anotherbilibili.ui.activity

import android.animation.Animator
import android.animation.ObjectAnimator
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity
import cn.leancloud.AVUser

/**
 * 闪屏页
 */
class SplashActivity : baseActivity() {

    override fun initData() {

    }

    override fun initView() {
        val objectAnimator = ObjectAnimator.ofFloat(im_splash, "alpha", 0.4f, 1f)
        with(objectAnimator)
        {
            duration = 2000
            objectAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}

                override fun onAnimationEnd(animation: Animator?) {
                    checkIsLogin()

                }

                override fun onAnimationCancel(animation: Animator?) {}

                override fun onAnimationStart(animation: Animator?) {}

            })

            start()

        }

    }

    fun checkIsLogin() {
        val currentUser = AVUser.getCurrentUser()
        if (currentUser != null) {
            // 跳到首页
            startActivity<HomeActivity>()
            finish()
        } else {
            // 显示注册或登录页面
            startActivity<LoginActivity>()
            finish()
        }
    }

    override fun finalPrepare() {


    }


    override fun getLayoutId(): Int = R.layout.activity_splash

}



