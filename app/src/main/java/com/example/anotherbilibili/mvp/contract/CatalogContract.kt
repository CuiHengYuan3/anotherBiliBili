package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean

interface CatalogContract {
    interface view : IBaseView {
        fun setCatalogData(catalogBeanList:ArrayList<CatalogBean> )
    }

    interface presenter {

        fun requestCatalogData()

    }


}