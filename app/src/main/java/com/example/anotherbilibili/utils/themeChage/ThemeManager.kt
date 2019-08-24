package com.example.anotherbilibili.utils.themeChage

import cn.leancloud.AVUser
import com.example.anotherbilibili.base.baseActivity
/**
 * 主题切换管理单例类
 */
class ThemeManager private constructor() {

    companion object {

        fun get() = Companion.Holder.instance

        private object Holder {
            val instance = ThemeManager()
        }
    }

    fun showTheme(activity: baseActivity,avUser: AVUser? = null, iThemeView: IThemeView? = null) {
        iThemeView?.let {
            ThemeAgency(it).setTheme(activity)
            return
        }
        val theme = avUser?.let { getThemeType(it) }
        val themeView = theme?.let { getThemeView(it) }
        if (themeView != null) {
            ThemeAgency(themeView).setTheme(activity)
        }


    }


}