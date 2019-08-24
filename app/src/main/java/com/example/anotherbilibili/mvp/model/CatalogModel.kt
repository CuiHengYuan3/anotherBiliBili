package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import io.reactivex.Observable


/**
 * 分类页面的model
 */


class CatalogModel {

    fun resquestCatalogData(): Observable<ArrayList<CatalogBean>> {

        return RetrofitManager.service.getCatalogData().compose(SchedulerUtils.ioToMain())

    }


}