package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.RankBean


/**
 * 排行榜页面的契约类
 */

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