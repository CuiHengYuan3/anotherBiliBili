package com.example.anotherbilibili.utils.themeChage

import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity


/**
 * 蓝色主题
 */
class BuleThemeView : IThemeView {


    override fun setTheme(acitvity: baseActivity) {
        baseActivity.defaultTheme = R.style.AppTheme_Bule
        acitvity.recreate()
    }

    override fun getMatchedTheme() = R.style.AppTheme_Bule

}