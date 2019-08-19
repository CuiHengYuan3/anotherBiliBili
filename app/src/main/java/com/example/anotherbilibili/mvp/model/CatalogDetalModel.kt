package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import io.reactivex.Observable

class CatalogDetalModel {
    fun resquestCatalogDetailData(text:String): Observable<CatalogDetailBean> {

        return RetrofitManager.service.getCatalogDetailData(text).compose(SchedulerUtils.ioToMain())

    }


}