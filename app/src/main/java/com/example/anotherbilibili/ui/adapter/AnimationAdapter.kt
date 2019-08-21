package com.example.anotherbilibili.ui.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.setImageUrl

class AnimationAdapter(
    mContext: Context, var animationList: ArrayList<AnimationBean.Result.RecommendCn.Recommend>,
    private var itemLayoutId: Int
) : BaseAdapter<AnimationBean.Result.RecommendCn.Recommend>(mContext, animationList, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: AnimationBean.Result.RecommendCn.Recommend, position: Int) {
        holder.getView<AppCompatImageView>(R.id.im_item_animatoin).setImageUrl(data.cover)
        holder.getView<AppCompatTextView>(R.id.tv_title_animation).text = data.title
        holder.getView<AppCompatTextView>(R.id.tv_follower).text = data.favourites+"人追番"

    }
}