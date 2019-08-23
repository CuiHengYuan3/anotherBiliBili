package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView

interface HomeContract {

    interface view : IBaseView {
        fun chageTheme()
        fun showThemeChangeDialog()
    }

    interface presenter {
        fun chageThemeByUser()
    }

}