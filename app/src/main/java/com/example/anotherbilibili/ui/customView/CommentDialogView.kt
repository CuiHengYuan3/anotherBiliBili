package com.example.anotherbilibili.ui.customView

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.anotherbilibili.R
import com.example.anotherbilibili.utils.KeybordUtils
import com.lxj.xpopup.core.BottomPopupView

/**
 * 显示评论的dialog
 * 使用到储存一个lambda，然后在具体页面实现具体逻辑
 */
class CommentDialogView(context: Context) : BottomPopupView(context) {


    //定义一个lambda监听，具体实现在评论页面定义
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

                //使用lambda的invoeke
                sendCommentListener!!.invoke(editText.text.toString())

                dismiss()
                KeybordUtils.closeKeyBord(editText, mContext = context)
                editText.text = null
            }
        }


    }


}