package com.example.anotherbilibili.mvp.presenter

import cn.leancloud.AVUser
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.contract.RecommendContract
import com.example.anotherbilibili.mvp.contract.RegisterContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class RegisterPresenter : BasePresenter<RegisterContract.view>(), RegisterContract.presenter {


    override fun Login(user: AVUser) {
        AVUser.logIn(user.username, user.password).subscribe(object : Observer<AVUser> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(user: AVUser) {
                // 登录成功
                finalView?.login()
            }


            override fun onError(throwable: Throwable) {
                // 登录失败（可能是密码错误）
                finalView?.loginEorr()
            }

            override fun onComplete() {}
        })

    }


    override fun sendVertification(phoneNumber: String) {
     Thread(Runnable {
         AVUser.requestLoginSmsCodeInBackground("+86$phoneNumber").blockingSubscribe()

     })

    }

    override fun checkVertification(phoneNumber: String, vertiNumber: String) {
        AVUser.signUpOrLoginByMobilePhoneInBackground("+86$phoneNumber", vertiNumber)
            .subscribe(object : Observer<AVUser> {
                override fun onSubscribe(disposable: Disposable) {}
                override fun onNext(user: AVUser) {
                    // 注册成功,username 将与 mobilePhoneNumber 相同，password 会由云端随机生成。
                    finalView?.registerOk(user)
                }

                override fun onError(throwable: Throwable) {
                    // 验证码不正确
                    finalView?.registerFailed()
                }

                override fun onComplete() {}
            })
    }


}