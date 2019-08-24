package com.example.anotherbilibili.ui.activity

import android.text.Editable
import android.util.Log
import cn.leancloud.AVUser
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.contract.LoginContract
import com.example.anotherbilibili.mvp.presenter.LoginPresenter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast



/**
 * 登陆页面
 *
 */



class LoginActivity : baseActivity(), LoginContract.view {


    override fun getLayoutId(): Int = R.layout.activity_login
    private val loginPresenter by lazy {
        LoginPresenter()
    }

    override fun initData() {
        val userName = intent.getCharSequenceExtra("userName")
        userName?.let {
            ed_account.setText(it)
            ed_password.isFocusable = true
            ed_password.isFocusableInTouchMode = true
            ed_password.requestFocus()
        }


    }

    override fun initView() {
        loginPresenter.bindView(this)
        initListener()
        wv.startAnimation()
    }

    override fun loginOk(user: AVUser) {

    }

    override fun loginFailed() {
        toast("登录失败，用户名或密码不正确")
    }


    fun initListener() {
        btn_register.setOnClickListener {
            startActivity<RegisterActivity>()
        }
        tv_passger.setOnClickListener {
            startActivity<HomeActivity>()

        }
        btn_login.setOnClickListener {

            if (ed_account.text.toString() == "" || ed_password.text.toString() == "") {
                toast("密码和用户名不能为空")
                return@setOnClickListener
            }
            AVUser.logIn(ed_account.text.toString(), ed_password.text.toString()).subscribe(object :
                Observer<AVUser> {
                override fun onSubscribe(disposable: Disposable) {}
                override fun onNext(user: AVUser) {
                    // 登录成功
                    toast("登陆成功")
                    startActivity<HomeActivity>()
                }


                override fun onError(throwable: Throwable) {
                    // 登录失败（可能是密码错误）
//                    finalView?.loginEorr()
                    toast("登陆失败")

                }

                override fun onComplete() {}
            })


        }

    }


    override fun finalPrepare() {
    }

    override fun showIsLoading() {
    }

    override fun removeLoading() {
    }


}
