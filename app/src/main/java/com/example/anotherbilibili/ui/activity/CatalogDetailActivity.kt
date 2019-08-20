package com.example.anotherbilibili.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseActivity
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.contract.CatalogDetailContact
import com.example.anotherbilibili.mvp.presenter.CatalogDetailPresenter
import com.example.anotherbilibili.setImageUrl
import com.example.anotherbilibili.ui.adapter.CatalogDetailAdapter

import kotlinx.android.synthetic.main.activity_catalog_detail.*

@SuppressLint("WrongConstant")
class CatalogDetailActivity : baseActivity(), CatalogDetailContact.view {

    var cataLogBean: CatalogBean? = null

    val mPresenter by lazy {
        CatalogDetailPresenter()
    }
    var catalogDetailAdapter: CatalogDetailAdapter? = null

    val linearLayoutManager by lazy {
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun getLayoutId(): Int = R.layout.activity_catalog_detail

    override fun initData() {
        cataLogBean = intent.getSerializableExtra("data") as CatalogBean?
        toolbar.title = cataLogBean?.name
        tv_category_descrpiton.text= cataLogBean?.description

        cataLogBean?.headerImage?.let { im_catalog_detail.setImageUrl(it) }
        re_catalog_detail.layoutManager = linearLayoutManager
    }


    override fun setCatalogDetalData(catalogDetailBean: CatalogDetailBean) {



      val a =getAdapterBean(catalogDetailBean)
        catalogDetailAdapter =
            CatalogDetailAdapter(this, a, R.layout.item_catalog_detail)
        re_catalog_detail.adapter = catalogDetailAdapter

    }


    override fun initView() {
        mPresenter.bindView(this)
        cataLogBean?.name?.let { mPresenter.requestCatalogDetailData(it) }

    }


    override fun finalPrepare() {
    }

    override fun showIsLoading() {
    }

    override fun removeLoading() {
    }

    fun getAdapterBean(catalogDetailBean: CatalogDetailBean): ArrayList<CatalogDetailBean.Item.Data.Content.Data> {

        var adapterBeanList: MutableList<CatalogDetailBean.Item.Data.Content.Data>
        adapterBeanList = ArrayList()
        for (i in catalogDetailBean.itemList) {
            adapterBeanList.add(i?.data.content?.data)
        }
        return adapterBeanList
    }
}
