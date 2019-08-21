package com.example.anotherbilibili.mvp.presenter

import android.annotation.SuppressLint
import android.util.Log
import cn.leancloud.utils.LogUtil
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.contract.CatalogDetailContact
import com.example.anotherbilibili.mvp.model.CatalogDetalModel
import kotlin.math.log

class CatalogDetailPresenter : BasePresenter<CatalogDetailContact.view>(), CatalogDetailContact.presenter {

    var catalogDetailBean: CatalogDetailBean? = null

    val model by lazy {
        CatalogDetalModel()
    }

    @SuppressLint("CheckResult")
    override fun requestCatalogDetailData(text: String) {
        finalView?.showIsLoading()
        model.resquestCatalogDetailData(text).subscribe {

            catalogDetailBean = it
            for (i in it.itemList) {
            }
            val fiteredList = it.itemList.filter {
                it.type == "followCard"
            }
            catalogDetailBean!!.itemList = fiteredList

            finalView?.removeLoading()
            finalView?.setCatalogDetalData(catalogDetailBean!!)
        }

    }


}