package com.example.anotherbilibili.utils.themeChage

import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity

/**
 * 绿色主题
 */
class GreenThemeView : IThemeView {


    override fun setTheme(acitvity: baseActivity) {
       baseActivity.defaultTheme=R.style.AppTheme_Green
        acitvity.recreate()
    }

    override fun getMatchedTheme() = R.style.AppTheme_Green

}