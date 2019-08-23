package com.example.anotherbilibili.utils

import cn.leancloud.AVUser


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
    "PINK" ->ThemeType.Pink
    "BLUE"->ThemeType.Blue
    "GREEN"->ThemeType.Green
    else -> ThemeType.Pink
}

