package com.example.anotherbilibili.utils.themeChage

import com.example.anotherbilibili.utils.themeChage.IThemeView

/**
 *
 * 主题切换的动态代理类，通过 by 委托来实现
 *
 */


class ThemeAgency(iThemeView: IThemeView) : IThemeView by iThemeView
