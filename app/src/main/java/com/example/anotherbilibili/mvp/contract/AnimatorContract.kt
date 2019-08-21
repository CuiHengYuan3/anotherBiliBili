package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean

interface AnimatorContract {


    interface view : IBaseView {
        fun setCatalogDetalData(animationList: MutableList<AnimationBean.Result.RecommendCn.Recommend>)
    }

    interface presenter {

        fun requestAnimationData()

    }
}