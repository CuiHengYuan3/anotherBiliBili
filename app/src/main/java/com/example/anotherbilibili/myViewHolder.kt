package com.example.anotherbilibili

import android.annotation.SuppressLint
import android.util.SparseArray
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * 封装的holder
 */
class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    private var mView: SparseArray<View>? = null

    init {
        mView = SparseArray()
    }

    fun <T : View> getView(viewId: Int): T {//以前都是要tv=itemView.fid()
        //对已有的view做缓存
        var view: View? = mView?.get(viewId)
        //使用缓存的方式减少findViewById的次数
        if (view == null) {
            view = itemView.findViewById(viewId)
            mView?.put(viewId, view)
        }
        return view as T
    }


    // @SuppressLint("SetTextI18n")
    //通用的功能进行封装  设置文本 设置条目点击事件  设置图片
    @SuppressLint("SetTextI18n")
    fun setText(viewId: Int, text: CharSequence): MyViewHolder {
        val view = getView<TextView>(viewId)
        view.text = "" + text
        return this
    }


    fun setImageResource(viewId: Int, resId: Int): MyViewHolder {
        val iv = getView<ImageView>(viewId)
        iv.setImageResource(resId)
        return this
    }

    fun setImagePath(viewId: Int, path: String): MyViewHolder {
        val iv = getView<AppCompatImageView>(viewId)
        iv.setImageUrl(path)
        return this
    }


    fun setOnItemClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }


    fun setOnItemLongClickListener(listener: View.OnLongClickListener) {
        itemView.setOnLongClickListener(listener)
    }

}