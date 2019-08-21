package com.example.anotherbilibili.ui

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.anotherbilibili.R
import com.example.anotherbilibili.utils.KeybordUtils
import com.lxj.xpopup.core.BottomPopupView

class CommentDialogView(context: Context) : BottomPopupView(context) {

    var sendCommentListener: ((tag: String) -> Unit)? = null
        set(value) {
            field = value
        }

    override fun getImplLayoutId(): Int {
        return R.layout.dialog_comment
    }

    override fun onCreate() {
        super.onCreate()
        val editText = findViewById<AppCompatEditText>(R.id.ed_comment)
        sendCommentListener?.let {
            findViewById<AppCompatButton>(R.id.btn_comment).setOnClickListener {
                sendCommentListener!!.invoke(editText.text.toString())
                dismiss()
                KeybordUtils.closeKeyBord(editText, mContext = context)
                editText.text = null
            }
        }


    }


}