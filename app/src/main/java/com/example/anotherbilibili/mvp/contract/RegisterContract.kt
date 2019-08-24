package com.example.anotherbilibili.mvp.contract

import cn.leancloud.AVUser
import com.example.anotherbilibili.base.IBaseView

/**
 * 注册页面的契约类
 */


interface RegisterContract {
    interface view : IBaseView {
        fun registerOk(user: AVUser)
        fun registerFailed()
        fun login()
        fun loginEorr()
        fun backToLoginAcivityWithData(user: AVUser)
    }

    interface presenter {
        fun sendVertification(phoneNumber: String)
        fun checkVertification(phoneNumber: String, vertiNumber: String)
        fun Login(user: AVUser)
        fun register(userName: String, password: String)
    }
}