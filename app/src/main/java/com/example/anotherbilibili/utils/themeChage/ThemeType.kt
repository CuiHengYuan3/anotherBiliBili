package com.example.anotherbilibili.utils.themeChage

import cn.leancloud.AVUser

/**
 * 获取主题的顶层函数和主题密闭类
 */


sealed class ThemeType {

    object Pink : ThemeType()
    object Green : ThemeType()
    object Blue : ThemeType()


}


fun getThemeView(type: ThemeType) =
    when (type) {
        ThemeType.Pink -> PinkThemeView()
        ThemeType.Green -> GreenThemeView()
        ThemeType.Blue -> BuleThemeView()
        else -> PinkThemeView()
    }

fun getThemeType(avUser: AVUser) = when (avUser.get("Theme")) {
    "PINK" -> ThemeType.Pink
    "BLUE" -> ThemeType.Blue
    "GREEN" -> ThemeType.Green
    else -> ThemeType.Pink
}

