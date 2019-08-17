package com.example.anotherbilibili.mvp.presenter

import android.annotation.SuppressLint
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.model.RecommendmModel
import com.example.anotherbilibili.mvp.contract.RecommendContract

class RecommendPresenter: BasePresenter<RecommendContract.view>(),RecommendContract.presenter {

var recommendBean:RecommendBean?=null

val recommendmModel by lazy {
    RecommendmModel()
}


    @SuppressLint("CheckResult")
    override fun requestData() {
        finalView?.showIsLoading()
        recommendmModel.resquestRecommendData().subscribe {
         recommendBean=it
            finalView?.removeLoading()
            finalView?.setRecommendData(recommendBean)

    }


    }

    @SuppressLint("CheckResult")
    override fun requestMoreData() {

        finalView?.showIsLoading()
        recommendmModel.resquestMoreRecommendData().subscribe {
            finalView?.removeLoading()
            finalView?.setMoreData(it)

        }

    }

}