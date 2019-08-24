package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.InformationData

/**
 * 追番页面的契约类
 */

interface AnimatorContract {


    interface view : IBaseView {
        fun setCatalogDetalData(animationList: MutableList<AnimationBean.Result.RecommendCn.Recommend>)
        fun setInformationData(informationData: InformationData)
    }


    interface presenter {

        fun requestAnimationData()
        fun requestInformationData()
    }
}