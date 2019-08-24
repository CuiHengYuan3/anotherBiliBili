package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.NewRecommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean


/**
 * 首页推荐页面的契约类
 */

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