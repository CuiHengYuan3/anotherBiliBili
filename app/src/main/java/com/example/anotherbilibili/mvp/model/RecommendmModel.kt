package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.NewRecommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import com.example.anotherbilibili.network.UrlFixed
import io.reactivex.Observable


/**
 * 首页推荐页面的model
 */

class RecommendmModel {

    fun resquestRecommendData(page: Int): Observable<NewRecommendBean> {

        return RetrofitManager.service.getNewRecommendData(page, 10, UrlFixed.TYPE).compose(SchedulerUtils.ioToMain())

    }

    fun resquestMoreRecommendData(page: Int): Observable<NewRecommendBean> {

        return RetrofitManager.service.getNewRecommendData(page, 10, UrlFixed.TYPE).compose(SchedulerUtils.ioToMain())

    }


}


