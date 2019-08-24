package com.example.anotherbilibili.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.bumptech.glide.Glide
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.mvp.Bean.RankBean
import com.example.anotherbilibili.setImageUrl
import com.example.anotherbilibili.ui.activity.VideoAcitvity
import kotlinx.android.synthetic.main.content_video_acitvity.*
import kotlinx.android.synthetic.main.item_rank.view.*
import java.lang.StringBuilder



/**
 *
 * 排行榜页面adapter
 */
class RankAdapter(
    mContext: Context, mData: ArrayList<RankBean.Item>,
    private var itemLayoutId: Int
) : BaseAdapter<RankBean.Item>(mContext, mData, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: RankBean.Item, position: Int) {
        holder.getView<AppCompatImageView>(R.id.im_rank_item).setImageUrl(data.data.cover.feed)
        holder.getView<AppCompatTextView>(R.id.tv_title).text = data.data.title
        val stringBuilder = StringBuilder()
        for (i in data.data.tags) {
            stringBuilder.append(i.name).append("/")
        }
        holder.getView<AppCompatTextView>(R.id.tv_tags).text = stringBuilder.toString()
        holder.setText(R.id.tv_user_id_rank, data.data.author.name)

        holder.getView<View>(R.id.im_user_rank)
            .let { Glide.with(mContext).load(data.data.author.icon).into(it as ImageView?) }
        holder.setText(R.id.tv_publishTime_rank, "2019-08-21 11:11:11")

        holder.setOnItemClickListener(View.OnClickListener {
            val intent = Intent(mContext, VideoAcitvity::class.java)
            intent.putExtra("rankData", data)
            intent.putExtra(VideoAcitvity.TRANSITION, true)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                val pairView =
                    androidx.core.util.Pair( holder.getView<AppCompatImageView>(R.id.im_rank_item) as View, VideoAcitvity.TRANSITIONVIEW)
                val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity, pairView
                )
                ActivityCompat.startActivity(mContext, intent, activityOptions.toBundle())
            } else {
                mContext.startActivity(intent)
            }


        })


    }


}