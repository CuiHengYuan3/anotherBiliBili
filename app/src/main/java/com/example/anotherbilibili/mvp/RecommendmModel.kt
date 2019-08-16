package com.example.anotherbilibili.mvp

import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import io.reactivex.Observable

class RecommendmModel {

fun  resquestRecommendData():Observable<RecommendBean>{

  return RetrofitManager.service.getRecommendData().compose(SchedulerUtils.ioToMain())

}


}


