package com.example.anotherbilibili.mvp.presenter

import android.annotation.SuppressLint
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.contract.AnimatorContract
import com.example.anotherbilibili.mvp.model.AnimationModel
import com.example.anotherbilibili.mvp.model.CatalogDetalModel


/**
 * 追番页面的presenter
 */
class AnimationPresenter : BasePresenter<AnimatorContract.view>(), AnimatorContract.presenter {


    var recommendList: MutableList<AnimationBean.Result.RecommendCn.Recommend>? = null

    val model by lazy {
        AnimationModel()
    }


    @SuppressLint("CheckResult")
    override fun requestAnimationData() {
        finalView?.showIsLoading()
        model.resquestAnimationData().subscribe {
            recommendList =
                it?.result?.recommendCn?.recommend as MutableList<AnimationBean.Result.RecommendCn.Recommend>
            recommendList?.addAll(it.result.recommendJp.recommend)
            finalView?.setCatalogDetalData(recommendList ?: return@subscribe)
        }
    }

    @SuppressLint("CheckResult")
    override fun requestInformationData() {
        model.requsetInformationData().subscribe {
            finalView?.setInformationData(it ?: return@subscribe)
            finalView?.removeLoading()
        }


    }


}