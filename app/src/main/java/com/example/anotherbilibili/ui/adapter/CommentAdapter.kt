package com.example.anotherbilibili.ui.adapter

import android.content.Context
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.setImageUrl
import de.hdodenhof.circleimageview.CircleImageView
import org.jetbrains.anko.imageURI

class CommentAdapter(
    mContext: Context, mData: ArrayList<CommendBean?>,
    private var itemLayoutId: Int
) : BaseAdapter<CommendBean?>(mContext, mData, itemLayoutId) {

    override fun bindData(holder: MyViewHolder, data: CommendBean?, position: Int) {
        val userImage = holder.getView<CircleImageView>(R.id.im_user_pic) as AppCompatImageView
        data?.userPic?.let { userImage.setImageUrl(it) }
        holder.getView<TextView>(R.id.tv_user_id).text = data?.userName ?:"无名之人"
        holder.getView<TextView>(R.id.tv_comment_text).text = data?.commendText
    }

}