package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import com.example.anotherbilibili.network.UrlFixed
import io.reactivex.Observable

class AnimationModel {


    fun resquestAnimationData(): Observable<AnimationBean> {

        return RetrofitManager.service.getAnimationData(
            UrlFixed.APPKEY,
            UrlFixed.BULID,
            UrlFixed.MOBI_APP,
            UrlFixed.PLATFORM,
            UrlFixed.TS,
            UrlFixed.SIGN
        ).compose(SchedulerUtils.ioToMain())

    }


}