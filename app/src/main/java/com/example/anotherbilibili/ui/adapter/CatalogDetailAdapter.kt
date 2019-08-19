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
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.setImageUrl
import com.example.anotherbilibili.ui.activity.VideoAcitvity
import org.jetbrains.anko.startActivity

class CatalogDetailAdapter(
    mContext: Context, mData: ArrayList<CatalogDetailBean.Item.Data.Content.Data>?,//这个bean太复杂了.......
    private var itemLayoutId: Int
) : BaseAdapter<CatalogDetailBean.Item.Data.Content.Data>(mContext, mData!!, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: CatalogDetailBean.Item.Data.Content.Data, position: Int) {

        val picImage = holder.getView<AppCompatImageView>(R.id.im_item_catalog_detail)
        val textView = holder.getView<AppCompatTextView>(R.id.tv_catalog_detail)
        picImage.setImageUrl(data.cover.feed)
        textView.text = data.title

        holder.setOnItemClickListener(View.OnClickListener {
         //   mContext.startActivity<VideoAcitvity>(Pair("catalogDetailData",data))
            val intent = Intent(mContext, VideoAcitvity::class.java)
            intent.putExtra("catalogDetailData", data)
            intent.putExtra(VideoAcitvity.TRANSITION, true)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                val pairView = androidx.core.util.Pair(picImage as View, VideoAcitvity.TRANSITIONVIEW)
                //  val pairUrl  = Pair("url", itemData.videouri)

                val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    mContext as Activity, pairView)
                ActivityCompat.startActivity(mContext, intent, activityOptions.toBundle())
            } else {
                mContext.startActivity(intent)
            }




        })

    }


}