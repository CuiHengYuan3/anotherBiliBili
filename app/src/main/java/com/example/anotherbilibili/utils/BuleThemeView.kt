package com.example.anotherbilibili.utils

import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.ui.activity.HomeActivity
import org.jetbrains.anko.startActivity

class BuleThemeView : IThemeView {


    override fun setTheme(acitvity: baseActivity) {
        baseActivity.defaultTheme = R.style.AppTheme_Bule
        acitvity.recreate()
    }

    override fun getMatchedTheme() = R.style.AppTheme_Bule

}