package com.example.anotherbilibili.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.SyncStateContract
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import cn.leancloud.AVException
import cn.leancloud.AVObject
import cn.leancloud.AVUser
import com.example.anotherbilibili.MyViewHolder
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.BaseAdapter
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.ui.activity.VideoAcitvity
import org.jetbrains.anko.startActivity

class RecommendAdapter(
    mContext: Context, mData: ArrayList<RecommendBean.Data>,
    private var itemLayoutId: Int
) : BaseAdapter<RecommendBean.Data>(mContext, mData, itemLayoutId) {


    override fun bindData(holder: MyViewHolder, data: RecommendBean.Data, position: Int) {
        with(holder) {
            setText(R.id.tv_title, data.tiltle)
            setImagePath(R.id.im_item, data.bimageuri)
            setText(R.id.tv_author, data.name)
            setImagePath(R.id.im_mini, data.profileImage)
            holder.setOnItemClickListener(View.OnClickListener {
             Thread(Runnable {
                 val testObject = AVObject("啊啊啊")
                 testObject.put("words", "Hello world!")
                 testObject.saveInBackground().blockingSubscribe()

                 val user= AVUser();
                 user.setUsername("崔恒源");
                 user.setEmail("1210002860@qq.com");
                 user.setPassword(123456.toString());
                 user.signUpInBackground()




             })

                //   (mContext as Activity).startActivity<VideoAcitvity>(pair)
goToVideoPlayer(mContext as Activity,holder.getView(R.id.im_item),data)
            })
        }


    }

    private fun goToVideoPlayer(activity: Activity, view: View, itemData:RecommendBean.Data) {
        val intent = Intent(activity, VideoAcitvity::class.java)
        intent.putExtra("itemData", itemData)
        intent.putExtra(VideoAcitvity.TRANSITION, true)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val pairView = androidx.core.util.Pair(view, VideoAcitvity.TRANSITIONVIEW)
          //  val pairUrl  = Pair("url", itemData.videouri)

            val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity, pairView)
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle())
        } else {
            activity.startActivity(intent)
        }
    }

}