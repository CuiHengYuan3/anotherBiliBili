package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.contract.CatalogContract
import com.example.anotherbilibili.mvp.presenter.CatalogPresenter
import com.example.anotherbilibili.ui.adapter.CatalogAdapter
import kotlinx.android.synthetic.main.fragment_catalog.*


/**
 *
 * 分类fragment
 */
class CatalogFragment : baseFragment(), CatalogContract.view {


    val imageIdList = arrayListOf(
        R.mipmap.ic_category_t119,
        R.mipmap.ic_category_t121,
        R.mipmap.ic_category_t122,
        R.mipmap.ic_category_t124,
        R.mipmap.ic_category_t126,
        R.mipmap.ic_category_t127,
        R.mipmap.ic_category_t128,
        R.mipmap.ic_category_t129,
        R.mipmap.ic_category_t130,
        R.mipmap.ic_category_t131,
        R.mipmap.ic_category_t136,
        R.mipmap.ic_category_t137,
        R.mipmap.ic_category_t138,
        R.mipmap.ic_category_t145,
        R.mipmap.ic_category_t146,
        R.mipmap.ic_category_t147,
        R.mipmap.ic_category_t152
    )

    var catalogAdapter: CatalogAdapter? = null
    override fun getLayoutId(): Int = R.layout.fragment_catalog
    val mPresenter by lazy {
        CatalogPresenter()
    }
    val gridLayoutManager by lazy {
        GridLayoutManager(MyApplication.context, 3)
    }

    companion object {
        fun getInstance(): CatalogFragment {
            val fragment = CatalogFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun setCatalogData(catalogBeanList: ArrayList<CatalogBean>) {
        catalogAdapter = activity?.let { CatalogAdapter(it, imageIdList, catalogBeanList, R.layout.item_catalog) }
        re_catalog.layoutManager = gridLayoutManager
        re_catalog.adapter = catalogAdapter
    }


    override fun initView() {
        mPresenter.bindView(this)
    }

    override fun lazyLoad() {
        mPresenter.requestCatalogData()
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }


    override fun showIsLoading() {

    }

    override fun removeLoading() {

    }

}