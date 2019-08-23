package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.RankBean

interface RankContract {
    interface view :IBaseView{
        fun setRankData(rankBean: RankBean)
    }

    interface presenter {

        fun requestWeekRankData()
        fun requestMonthRankData()
        fun requestHistoryRankData()

    }

}