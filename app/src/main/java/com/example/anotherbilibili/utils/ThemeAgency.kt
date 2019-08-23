package com.example.anotherbilibili.utils

/**
 *
 * 主题切换的代理类，通过 by 委托来实现
 *
 */


class ThemeAgency(iThemeView: IThemeView) : IThemeView by iThemeView
