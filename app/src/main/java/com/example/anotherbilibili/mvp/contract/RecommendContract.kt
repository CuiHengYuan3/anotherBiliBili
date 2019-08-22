package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.NewRecommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean

interface RecommendContract {
    interface view : IBaseView {
        fun setRecommendData(recommendBean: NewRecommendBean?)
        fun setMoreData(recommendBean: NewRecommendBean?)
        fun setTopMoreData(recommendBean: NewRecommendBean?)
    }

    interface presenter {
        fun requestData(count:Int)
        fun requestMoreData(count:Int)
        fun requestTopMoreData(count:Int)

    }


}