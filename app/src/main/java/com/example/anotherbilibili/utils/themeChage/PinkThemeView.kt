package com.example.anotherbilibili.utils.themeChage

import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.utils.themeChage.IThemeView



/**
 * 粉色主题
 */

class PinkThemeView : IThemeView {

    override fun setTheme(acitvity: baseActivity) {
        baseActivity.defaultTheme=R.style.AppTheme
       acitvity.recreate()
    }

    override fun getMatchedTheme() = R.style.AppTheme


}