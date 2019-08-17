package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.RecommendBean

interface VideoConstract {
interface  view:IBaseView{
    fun setVideoData(data:RecommendBean.Data)
}
interface  presenter{
    fun  loadVideodata(data:RecommendBean.Data)
}
}