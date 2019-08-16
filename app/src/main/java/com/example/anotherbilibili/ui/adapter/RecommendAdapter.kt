package com.example.anotherbilibili.ui.adapter

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.RecommendBean

class RecommendAdapter(
    mContext: Context, mData: ArrayList<RecommendBean.Data>,
    private var itemLayoutId: Int
) : BaseAdapter<RecommendBean.Data>(mContext, mData, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: RecommendBean.Data, position: Int) {
with(holder){
    setText(R.id.tv_title,data.tiltle)
    setImagePath(R.id.im_item,data.bimageuri)
    setText(R.id.tv_author,data.name)
   setImagePath(R.id.im_mini,data.profileImage)
setOnItemClickListener(View.OnClickListener {
})
}


    }


}