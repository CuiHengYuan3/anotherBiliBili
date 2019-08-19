package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.ExtractBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean

interface VideoConstract {
interface  view:IBaseView{
    fun setVideoData(data:ExtractBean)
}
interface  presenter{
    fun  loadVideodata(data:ExtractBean)
}
}