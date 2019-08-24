package com.example.anotherbilibili.mvp.presenter

import android.annotation.SuppressLint
import com.example.anotherbilibili.base.BasePresenter
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.contract.CatalogContract
import com.example.anotherbilibili.mvp.model.CatalogModel


/**
 * 分类页面的presenter
 */

class CatalogPresenter : BasePresenter<CatalogContract.view>(), CatalogContract.presenter {


    var catalogBeanList: ArrayList<CatalogBean>? = null

    val model by lazy {
        CatalogModel()
    }

    @SuppressLint("CheckResult")

    override fun requestCatalogData() {
        finalView?.showIsLoading()
        val disposable = model.resquestCatalogData().subscribe {
            catalogBeanList = it
            finalView?.setCatalogData(catalogBeanList!!)
        }

        addSubscription(disposable)
    }

}