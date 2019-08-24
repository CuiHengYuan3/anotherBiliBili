package com.example.anotherbilibili.mvp.contract

import android.content.Context
import cn.leancloud.AVObject
import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.ExtractBean

/**
 * 视频播放页面的契约类
 */


interface VideoConstract {
    interface view : IBaseView {
        fun setVideoData(data: ExtractBean)
        fun setDefaultData()
        fun setRefreshedData(data: AVObject?)
        fun setHasDataFromAV()//设置videoAcivity中标志是否云端有本视频数据的布尔值
    }

    interface presenter {
        fun loadVideodata(data: ExtractBean)
        fun pushToAV(extractBean: ExtractBean)
        fun reFreshAVdata(data: AVObject?, extractBean: ExtractBean)
        fun reFreshUserData(context: Context,extractBean: ExtractBean,isCollect:Boolean)

    }
}