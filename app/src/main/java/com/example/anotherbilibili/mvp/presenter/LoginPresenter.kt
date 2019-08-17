package com.example.anotherbilibili.mvp.presenter

import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.contract.LoginContract
import cn.leancloud.AVUser
import io.reactivex.Observer
import io.reactivex.disposables.Disposable



class LoginPresenter: BasePresenter<LoginContract.view>(),LoginContract.presenter {



    override fun checkLogin(userName: String, password: String) {
        AVUser.logIn("Tom", "cat!@#123").subscribe(object : Observer<AVUser> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(user: AVUser) {
                // 登录成功
                finalView?.loginOk(user)
            }

            override fun onError(throwable: Throwable) {
                // 登录失败（可能是密码错误）
                finalView?.loginFailed()
            }

            override fun onComplete() {}
        })

    }


}