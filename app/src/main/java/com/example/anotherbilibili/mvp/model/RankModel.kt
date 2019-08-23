package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.RankBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import io.reactivex.Observable

class RankModel {


    fun resquestRankData(strategy: String): Observable<RankBean> {

        return RetrofitManager.service.getRankData(strategy).compose(SchedulerUtils.ioToMain())

    }


}