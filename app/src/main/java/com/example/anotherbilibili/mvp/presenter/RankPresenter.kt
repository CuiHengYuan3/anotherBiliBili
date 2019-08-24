package com.example.anotherbilibili.mvp.presenter

import android.annotation.SuppressLint
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.contract.RankContract
import com.example.anotherbilibili.mvp.model.RankModel

/**
 * 排行榜页面的presenter
 */
class RankPresenter : BasePresenter<RankContract.view>(), RankContract.presenter {

    companion object {

        const val WEEKDATA = "weekly"
        const val MONTHDATA = "monthly"
        const val HISTORYDATA = "historical"

    }

    val model by lazy {
        RankModel()
    }


    @SuppressLint("CheckResult")
    override fun requestWeekRankData() {


        model.resquestRankData(WEEKDATA).subscribe {
            finalView?.showIsLoading()
            finalView?.setRankData(it)
            finalView?.removeLoading()
        }

    }

    @SuppressLint("CheckResult")
    override fun requestMonthRankData() {

        model.resquestRankData(MONTHDATA).subscribe {
            finalView?.showIsLoading()
            finalView?.setRankData(it)
            finalView?.removeLoading()
        }


    }

    @SuppressLint("CheckResult")
    override fun requestHistoryRankData() {
        model.resquestRankData(HISTORYDATA).subscribe {
            finalView?.showIsLoading()
            finalView?.setRankData(it)
            finalView?.removeLoading()
        }

    }

//还没有加入管理啊啊
}