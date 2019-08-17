package com.example.anotherbilibili.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.presenter.RecommendPresenter
import com.example.anotherbilibili.mvp.contract.RecommendContract
import com.example.anotherbilibili.ui.adapter.RecommendAdapter
import kotlinx.android.synthetic.main.fragment_commond.*


class CommondFragment : baseFragment(), RecommendContract.view {


    private var loadingMore = false

    private var isRefresh = false
    var recommendAdapter: RecommendAdapter? = null
    val mPresenter by lazy {
        RecommendPresenter()
    }

    val gridLayoutManager by lazy {
        GridLayoutManager(MyApplication.context, 2)
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
        re_commond.layoutManager = gridLayoutManager


    }

    override fun setMoreData(recommendBean: RecommendBean?) {
        loadingMore = false
        recommendBean?.data?.let { recommendAdapter?.mData?.addAll(it) }
        recommendAdapter?.notifyDataSetChanged()
    }


    override fun showIsLoading() {

    }

    override fun removeLoading() {

    }


    override fun initView() {
        mPresenter.bindView(this)
        initLisener()
    }

    override fun lazyLoad() {
        mPresenter.requestData()
    }

    fun initLisener(){


        re_commond.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val childCount = re_commond.childCount
                    val itemCount = re_commond.layoutManager?.itemCount
                    val firstVisibleItem = (re_commond.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true
                            mPresenter.requestMoreData()
                        }
                    }
                }
            }

    })
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