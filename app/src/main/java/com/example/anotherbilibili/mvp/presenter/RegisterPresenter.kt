package com.example.anotherbilibili.mvp.presenter

import android.util.Log
import cn.leancloud.AVUser
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.contract.RecommendContract
import com.example.anotherbilibili.mvp.contract.RegisterContract
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 注册页面的presenter
 */

class RegisterPresenter : BasePresenter<RegisterContract.view>(), RegisterContract.presenter {


    override fun register(userName: String, password: String) {
        finalView?.showIsLoading()
        val user = AVUser()

        user.username = userName
        user.password = password

       user.signUpInBackground().subscribe(object : Observer<AVUser> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(user: AVUser) {
                // 注册成功
                finalView?.removeLoading()
                finalView?.backToLoginAcivityWithData(user)
                Log.d("aaa", "注册成功")
            }

            override fun onError(throwable: Throwable) {
                // 注册失败（通常是因为用户名已被使用）
                finalView?.loginEorr()
                Log.d("aaa", "注册失败")
                finalView?.removeLoading()

            }

            override fun onComplete() {
                finalView?.removeLoading()
            }
        })

    }


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
                Log.d("aaa", "注册成功但是登陆失败")

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