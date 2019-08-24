package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean


/**
 * 分类页面的契约类
 */


interface CatalogContract {
    interface view : IBaseView {
        fun setCatalogData(catalogBeanList:ArrayList<CatalogBean> )
    }

    interface presenter {

        fun requestCatalogData()

    }


}