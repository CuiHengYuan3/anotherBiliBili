package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import cn.leancloud.AVUser
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.contract.RegisterContract
import com.example.anotherbilibili.mvp.presenter.RegisterPresenter

import kotlinx.android.synthetic.main.actvity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import com.lxj.xpopup.XPopup

/**
 *注册页面
 *
 */


class RegisterActivity : baseActivity(), RegisterContract.view {


    private val mPresenter by lazy {
        RegisterPresenter()
    }


    val waitDialog by lazy { XPopup.Builder(this).asLoading("正在注册中") }


    override fun getLayoutId(): Int = R.layout.actvity_register


    override fun initData() {
    }


    override fun initView() {
        mPresenter.bindView(this)
        initListener()
        tv_userName.requestFocus()
    }

    override fun backToLoginAcivityWithData(user: AVUser) {


        startActivity<LoginActivity>(Pair("userName", user.username))

    }

    override fun login() {
        toast("登陆成功")
        startActivity<HomeActivity>()
        finish()
    }

    override fun loginEorr() {
        toast("登陆失败")
    }

    override fun registerOk(user: AVUser) {

        mPresenter.Login(user)

    }

    override fun registerFailed() {

    }

    private fun initListener() {
        btn_verification.setOnClickListener {
            mPresenter.sendVertification(ed_phone.text.toString())
        }
        btn_register.setOnClickListener {
            if (ed_vertification.text.toString() != "") {
                toast("用电话注册")
                mPresenter.checkVertification(ed_phone.text.toString(), ed_vertification.text.toString())
            } else {
                toast("用用户名密码注册")
                mPresenter.register(ed_userName.text.toString(), ed_password.text.toString())
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }

    override fun finalPrepare() {
    }

    override fun showIsLoading() {
        waitDialog.show()

    }

    override fun removeLoading() {
        waitDialog.dismiss()
    }


}
