package com.example.anotherbilibili.mvp.presenter

import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.contract.VideoConstract

class VideoPresenter : BasePresenter<VideoConstract.view>(), VideoConstract.presenter {


    override fun loadVideodata(data: RecommendBean.Data) {
        finalView?.showIsLoading()
        finalView?.setVideoData(data)
        finalView?.removeLoading()
    }


}