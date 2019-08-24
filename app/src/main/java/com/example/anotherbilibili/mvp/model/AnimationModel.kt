package com.example.anotherbilibili.mvp.model

import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.InformationData
import com.example.anotherbilibili.network.RetrofitManager
import com.example.anotherbilibili.network.SchedulerUtils
import com.example.anotherbilibili.network.UrlFixed
import io.reactivex.Observable

/**
 * 追番页面的model
 */


class AnimationModel {


    fun resquestAnimationData(): Observable<AnimationBean> {

        return RetrofitManager.service.getAnimationData(
            UrlFixed.APPKEY,
            UrlFixed.BULID_ANIMATION,
            UrlFixed.MOBI_APP,
            UrlFixed.PLATFORM,
            UrlFixed.TS_ANIMATION,
            UrlFixed.SIGN_ANIMATION
        ).compose(SchedulerUtils.ioToMain())

    }

    fun requsetInformationData(): Observable<InformationData> {

        return RetrofitManager.service.getInformationData(
            UrlFixed.APPKEY,
            UrlFixed.BULID_INFO,
            UrlFixed.CURSOR,
            UrlFixed.MOBI_APP,
            UrlFixed.PLATFORM,
            UrlFixed.TS_INFO,
            UrlFixed.SIGN_INFO
        ).compose(SchedulerUtils.ioToMain())


    }

}