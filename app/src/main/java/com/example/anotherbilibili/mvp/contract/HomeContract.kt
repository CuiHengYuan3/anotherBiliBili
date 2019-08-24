package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView


/**
 * 主页面的契约类
 */


interface HomeContract {

    interface view : IBaseView {
        fun chageTheme()
        fun showThemeChangeDialog()
    }

    interface presenter {
        fun chageThemeByUser()
    }

}