package com.example.anotherbilibili.ui.adapter

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.mvp.Bean.InformationData
import com.example.anotherbilibili.setImageUrl
import com.example.anotherbilibili.ui.activity.WebActivity
import org.jetbrains.anko.startActivity


/**
 *
 * 追番页面资讯adapter
 */

class InformationAdapter(
    mContext: Context, mData: ArrayList<InformationData.Result>,
    private var itemLayoutId: Int
) : BaseAdapter<InformationData.Result>(mContext, mData, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: InformationData.Result, position: Int) {
        holder.getView<AppCompatImageView>(R.id.im_item_info).setImageUrl(data.cover)
        holder.setText(R.id.tv_title_infor, data.title)
        data.desc?.let { holder.setText(R.id.tv_item_descr, it) }

        holder.setOnItemClickListener(View.OnClickListener {
            mContext.startActivity<WebActivity>(Pair("link",data.link))
        })

    }


}