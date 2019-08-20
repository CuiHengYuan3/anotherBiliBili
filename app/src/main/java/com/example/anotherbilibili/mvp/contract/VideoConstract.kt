package com.example.anotherbilibili.mvp.contract

import cn.leancloud.AVObject
import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.ExtractBean

interface VideoConstract {
    interface view : IBaseView {
        fun setVideoData(data: ExtractBean)
        fun setDefaultData()
        fun setRefreshedData(data: AVObject?)
    }

    interface presenter {
        fun loadVideodata(data: ExtractBean)
        fun pushToAV(extractBean: ExtractBean)
        fun reFreshAVdata(data: AVObject?,extractBean: ExtractBean)
    }
}