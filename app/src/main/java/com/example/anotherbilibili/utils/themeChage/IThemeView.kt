package com.example.anotherbilibili.utils.themeChage

import androidx.appcompat.app.AppCompatActivity
import com.example.anotherbilibili.base.baseActivity


interface IThemeView {

    fun setTheme(acitvity:baseActivity)
fun  getMatchedTheme():Int
}
