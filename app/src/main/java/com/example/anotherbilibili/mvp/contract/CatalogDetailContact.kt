package com.example.anotherbilibili.mvp.contract

import com.example.anotherbilibili.base.IBaseView
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean

interface CatalogDetailContact {


    interface view : IBaseView {
        fun setCatalogDetalData(catalogDetailBean: CatalogDetailBean )
    }

    interface presenter {

        fun requestCatalogDetailData(text:String)

    }




}