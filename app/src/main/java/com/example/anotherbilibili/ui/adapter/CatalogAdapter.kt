package com.example.anotherbilibili.ui.adapter

import android.content.Context
import android.view.View
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.ui.activity.CatalogDetailActivity
import org.jetbrains.anko.startActivity



/**
 *
 * 分类页面adapter
 */
class CatalogAdapter(
    mContext: Context, var imgIdList: ArrayList<Int>, var catalogList: ArrayList<CatalogBean>,
    private var itemLayoutId: Int
) : BaseAdapter<Int>(mContext, imgIdList, itemLayoutId) {
    //这里的通用适配器不合适，有时间再改
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.setImageResource(R.id.im_catalog, imgIdList[position])
        holder.setText(R.id.tv_catalog, catalogList[position].name)

        holder.setOnItemClickListener(View.OnClickListener {
            mContext.startActivity<CatalogDetailActivity>(Pair("data", catalogList[position]))


        })
    }

    override fun bindData(holder: MyViewHolder, data: Int, position: Int) {

    }


}