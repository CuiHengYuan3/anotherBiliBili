package com.example.anotherbilibili.mvp.contract

import cn.leancloud.AVUser
import com.example.anotherbilibili.base.IBaseView

interface RegisterContract {
    interface view : IBaseView {
        fun registerOk(user: AVUser)
        fun registerFailed()
        fun  login()
    fun loginEorr()
    }

    interface presenter {
        fun sendVertification(phoneNumber: String)
        fun checkVertification(phoneNumber: String, vertiNumber: String)
        fun Login(user: AVUser)
    }
}