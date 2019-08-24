package com.example.anotherbilibili.ui.adapter

import android.content.Context
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.setImageUrl
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.imageURI



/**
 *
 * 评论adapter
 */

class CommentAdapter(
    mContext: Context, mData: ArrayList<CommendBean>,
    private var itemLayoutId: Int
) : BaseAdapter<CommendBean>(mContext, mData, itemLayoutId) {

    override fun bindData(holder: MyViewHolder, data: CommendBean, position: Int) {
        val userImage = holder.itemView.findViewById<CircleImageView>(R.id.im_user_pic)
        data.userPic?.let { Glide.with(mContext).load(it).into(userImage) }
        holder.getView<TextView>(R.id.tv_userName_comment).text = data.userName ?: "无名之人"
        holder.getView<TextView>(R.id.tv_comment_text).text = data.commendText


    }


}









