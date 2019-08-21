package com.example.anotherbilibili.utils

import android.content.Context

object Dip2pxUtil {


        fun dip2px(context: Context, dpValue: Double): Int {
            val density = context.resources.displayMetrics.density
            return (dpValue * density + 0.5).toInt()
        }


}