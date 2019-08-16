package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.RecommendPresenter
import com.example.anotherbilibili.mvp.contract.RecommendContract
import com.example.anotherbilibili.ui.adapter.RecommendAdapter
import kotlinx.android.synthetic.main.fragment_commond.*


class CommondFragment : baseFragment(), RecommendContract.view {

    var recommendAdapter: RecommendAdapter? = null
    val mPresenter by lazy {
        RecommendPresenter()
    }
    val gridLayoutManager by lazy {
  GridLayoutManager(MyApplication.context,2)
    }

    override fun setRecommendData(recommendBean: RecommendBean?) {
        recommendAdapter = activity?.let {
            RecommendAdapter(
                it,
                recommendBean?.data as ArrayList<RecommendBean.Data>,
                R.layout.item_recyle_recommend
            )
        }
        re_commond.adapter = recommendAdapter
        re_commond.layoutManager= gridLayoutManager
    }


    override fun setMoreData() {

    }

    override fun showIsLoading() {

    }

    override fun removeLoading() {

    }


    override fun initView() {
    mPresenter.bindView(this)
    }

    override fun lazyLoad() {
          mPresenter.requestData()
    }

    companion object {
        fun getInstance(): CommondFragment {
            val fragment = CommondFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_commond

}