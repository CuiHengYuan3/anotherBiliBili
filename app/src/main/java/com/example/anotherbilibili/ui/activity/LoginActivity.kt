package com.example.anotherbilibili.ui.activity

import cn.leancloud.AVUser
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.contract.LoginContract
import com.example.anotherbilibili.mvp.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class LoginActivity : baseActivity(), LoginContract.view {


    override fun getLayoutId(): Int = R.layout.activity_login
    private val loginPresenter by lazy {
        LoginPresenter()
    }

    override fun initData() {
    }

    override fun initView() {
        loginPresenter.bindView(this)
        initListener()
    }

    override fun loginOk(user: AVUser) {

    }

    override fun loginFailed() {
        toast("登录失败，用户名或密码不正确")
    }


    fun initListener() {
        btn_register.setOnClickListener {
            startActivity<RegisterActivity>()
            finish()
        }
    btn_passger.setOnClickListener {
        startActivity<HomeActivity>()

    }
    }


    override fun finalPrepare() {
    }

    override fun showIsLoading() {
    }

    override fun removeLoading() {
    }


}
