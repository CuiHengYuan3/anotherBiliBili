package com.example.anotherbilibili.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * 管理软键盘的工具类
 */
object KeybordUtils {

    fun openKeyBord(mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }

    fun closeKeyBord(mEditText: EditText, mContext: Context) {
        val imm = mContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(mEditText.windowToken, 0)
    }

}