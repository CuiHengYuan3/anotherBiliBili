package com.example.anotherbilibili.base

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.anotherbilibili.MyViewHolder

/**
 * 基类adapter,内部封装了一些常用方法和必须实现的方法
 * 使用的时候传入必要的参数即可，减少重复代码
 *
 */

abstract class BaseAdapter<T>(
    var mContext: Context, var mData: ArrayList<T>,
    private var itemLayoutId: Int
) : RecyclerView.Adapter<MyViewHolder>() {
    protected var mInflater: LayoutInflater? = null
    private var mItemClickListener: AdapterView.OnItemClickListener? = null
    var mutableHolderList: MutableList<MyViewHolder>? = ArrayList()

    //使用接口回调点击事件
    private var mItemLongClickListener: AdapterView.OnItemLongClickListener? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = mInflater?.inflate(itemLayoutId, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        mutableHolderList?.add(position, holder)
        bindData(holder, mData[position], position)

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setOnItemClickListener(itemClickListener: AdapterView.OnItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

    fun setOnItemLongClickListener(itemLongClickListener: AdapterView.OnItemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener
    }

    protected abstract fun bindData(holder: MyViewHolder, data: T, position: Int)



    open fun addData(datalist: ArrayList<T>) {//以后所有的adpter都可以直接调用这个方法来刷新数据

        this.mData.addAll(datalist)
        notifyDataSetChanged()
    }


}
