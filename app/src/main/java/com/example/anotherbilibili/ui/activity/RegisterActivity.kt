package com.example.anotherbilibili.ui.activity

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import cn.leancloud.AVUser
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.contract.RegisterContract
import com.example.anotherbilibili.mvp.presenter.RegisterPresenter

import kotlinx.android.synthetic.main.actvity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : baseActivity(), RegisterContract.view {


    private val mPresenter by lazy {
        RegisterPresenter()
    }


    override fun getLayoutId(): Int = R.layout.actvity_register


    override fun initData() {
    }

    override fun initView() {
        mPresenter.bindView(this)
        initListener()
    }

    override fun login() {
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
            mPresenter.checkVertification(ed_phone.text.toString(), ed_vertification.text.toString())
        }

    }


    override fun finalPrepare() {
    }

    override fun showIsLoading() {

    }

    override fun removeLoading() {

    }


}
