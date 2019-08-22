package com.example.anotherbilibili.utils

import android.content.Context

object Dip2pxUtil {


        fun dip2px(context: Context, dpValue: Double): Int {
            val density = context.resources.displayMetrics.density
            return (dpValue * density + 0.5).toInt()
        }
    fun   sp2px( context: Context,spValue:Float): Float {
        val  fontScale = context.resources.displayMetrics.scaledDensity;
        return  (spValue * fontScale + 0.5f)
    }


}