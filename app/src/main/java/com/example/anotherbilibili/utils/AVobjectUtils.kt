package com.example.anotherbilibili.utils

import android.content.Context
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import cn.leancloud.AVObject
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.toast
import java.math.MathContext
import cn.leancloud.AVUser
import com.example.anotherbilibili.mvp.Bean.CommendBean
import com.example.anotherbilibili.ui.activity.LoginActivity
import org.jetbrains.anko.startActivity


/**
*
 *
 * 与leancould交互的工具类，好像没有用到多少
 *
 *
 * 需要的几个功能
* 1.当用户点赞收藏评论的时候，储存当前的视频数据到云端并和用户关联。
* 由于此app的使用的api不止一种，所以只有当用户评论，收藏，喜欢的时候才把当前视频数据传到云端数据库
* 否则不传入
* 2.获取视频的信息，如果没有找到则不返回值
*
*
 *
* */


object AVobjectUtils {


    //获取当前用户，如果为空就跳转到登陆界面，并返回null，否则返回此用户
    fun getCurentUser(context: Context): AVUser? {
        var currentUser = AVUser.getCurrentUser()
        currentUser?.let { return it } ?: context.startActivity<LoginActivity>()
        return null
    }


    //在调用push函数之需要先设置好extractBean
    fun pushToAV(context: Context, extractBean: ExtractBean) {
        val videoData = AVObject("ExtractBean")
        with(videoData) {
            put("videoName", extractBean.videoName)
            put("videoUrl", extractBean.videoUrl)
            put("autherName", extractBean.autherName)
            put("autherImaeg", extractBean.autherImaeg)
            put("collectNumber", extractBean.collectNumber)
            put("videoPicUrl", extractBean.videoPicUrl)
            put("loveNumber", extractBean.loveNumber)
            put("commendList", extractBean.commendList)
        }

        videoData.saveInBackground().subscribe(object : Observer<AVObject> {
            override fun onSubscribe(disposable: Disposable) {}
            override fun onNext(todo: AVObject) {
                // 成功保存之后，执行其他逻辑
            }

            override fun onError(throwable: Throwable) {
                // 异常处理
            }

            override fun onComplete() {}
        })

    }

    fun hashMapToBean(hashMap: HashMap<String, String>): CommendBean {
        val userName = hashMap.get("userName")
        val commendText = hashMap.get("commendText")
        return CommendBean(null, userName, commendText)
    }

}