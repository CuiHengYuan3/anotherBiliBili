package com.example.anotherbilibili

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide

//inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) =
//    AnkoInternals.internalStartActivity(this, T::class.java, params)
fun AppCompatImageView.setImageUrl(urlSting:String){
Glide.with(MyApplication.context).load(urlSting).into(this)
}