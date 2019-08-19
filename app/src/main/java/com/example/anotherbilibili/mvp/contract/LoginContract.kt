package com.example.anotherbilibili.mvp.contract

import cn.leancloud.AVUser
import com.example.anotherbilibili.base.IBaseView

interface LoginContract {
    interface view : IBaseView {
        fun loginOk(user: AVUser)
        fun loginFailed()
    }

    interface presenter {
        fun checkLogin(userName: String, password: String)
    }

}