package com.example.anotherbilibili

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import com.example.anotherbilibili.mvp.Bean.NewRecommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean

//inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
//    AnkoInternals.internalStartActivity(this, T::class.java, params)
fun AppCompatImageView.setImageUrl(urlSting: String, hight: Int? = null, widith: Int? = null) {
    if (hight == null || widith == null) {
        Glide.with(MyApplication.context).load(urlSting).crossFade().into(this)
    } else {
        Glide.with(MyApplication.context).load(urlSting).override(widith, hight).crossFade().into(this)
    }
}


/**
 * 利用扩展函数
 * 把网络请求的bean类转换为自己的bean类，方便存储调用
 *
 * */
fun RecommendBean.Data.transferToExtractBean(): ExtractBean =
    ExtractBean(tiltle, videouri, name, profileImage, bimageuri)

fun NewRecommendBean.Result.transferToExtractBean(): ExtractBean =
    ExtractBean(tiltle, videouri, name, profileImage, bimageuri,publishTime = passtime)

fun CatalogDetailBean.Item.Data.Content.Data.transferToExtractBean(): ExtractBean =
    ExtractBean(title, playUrl, author.name, author.icon, cover.feed)
