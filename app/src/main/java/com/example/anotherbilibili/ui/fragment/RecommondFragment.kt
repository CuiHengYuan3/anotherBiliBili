package com.example.anotherbilibili.ui.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.event.ShowLoadingEvent
import com.example.anotherbilibili.mvp.Bean.NewRecommendBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import com.example.anotherbilibili.mvp.presenter.RecommendPresenter
import com.example.anotherbilibili.mvp.contract.RecommendContract
import com.example.anotherbilibili.ui.adapter.RecommendAdapter
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.BallPulseFooter
import com.scwang.smartrefresh.layout.header.BezierRadarHeader
import kotlinx.android.synthetic.main.content_video_acitvity.*
import kotlinx.android.synthetic.main.fragment_animation.*
import kotlinx.android.synthetic.main.fragment_commond.*
import org.greenrobot.eventbus.EventBus


/**
 *
 * 推荐fragment
 */
class RecommondFragment : baseFragment(), RecommendContract.view {


    private var loadingMore = false
    private var page = 1
    private var isRefresh = false
    var recommendAdapter: RecommendAdapter? = null
    val mPresenter by lazy {
        RecommendPresenter()
    }

    val gridLayoutManager by lazy {
        GridLayoutManager(MyApplication.context, 2)
    }

    override fun getLayoutId(): Int = R.layout.fragment_commond

    override fun setRecommendData(recommendBean: NewRecommendBean?) {
        recommendAdapter = activity?.let {
            RecommendAdapter(
                it,
                recommendBean?.result as ArrayList<NewRecommendBean.Result>,
                R.layout.item_recyle_recommend
            )
        }
        re_commond.adapter = recommendAdapter
        re_commond.layoutManager = gridLayoutManager


    }

    override fun setMoreData(recommendBean: NewRecommendBean?) {
        loadingMore = false
        recommendBean?.result?.let { recommendAdapter?.mData?.addAll(it) }
        recommendAdapter?.notifyDataSetChanged()
        sr_recommend.finishLoadMore()
    }

    override fun setTopMoreData(recommendBean: NewRecommendBean?) {
        isRefresh = false
        recommendBean?.result?.let { recommendAdapter?.mData?.addAll(0, it) }
        recommendAdapter?.notifyDataSetChanged()
        sr_recommend.finishRefresh()

    }


    override fun showIsLoading() {
        EventBus.getDefault().post(ShowLoadingEvent(true))
    }

    override fun removeLoading() {

        EventBus.getDefault().post(ShowLoadingEvent(false))
    }


    override fun initView() {
        mPresenter.bindView(this)
        initLisener()
    }

    override fun lazyLoad() {
        mPresenter.requestData(page)
    }

    @SuppressLint("ResourceType")
    fun initLisener() {
        sr_recommend.setRefreshHeader(BezierRadarHeader(this.activity).setEnableHorizontalDrag(true))
        sr_recommend.setRefreshFooter(BallPulseFooter(this.activity).setSpinnerStyle(SpinnerStyle.Scale))
        sr_recommend.setPrimaryColors(Color.parseColor("#FFC0CB"))

        sr_recommend.setOnLoadMoreListener {
            if (!loadingMore) {
                loadingMore = true
                page++
                mPresenter.requestMoreData(page)
            }

        }
        sr_recommend.setOnRefreshListener {
            if (!isRefresh) {
                isRefresh = true
                page++
                mPresenter.requestTopMoreData(page)
            }


        }


        re_commond.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val childCount = re_commond.childCount
                    val itemCount = re_commond.layoutManager?.itemCount
                    val firstVisibleItem =
                        (re_commond.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                    if (firstVisibleItem + childCount == itemCount) {
                        if (!loadingMore) {
                            loadingMore = true
                            page++
                            mPresenter.requestMoreData(page)
                        }
                    }
                }
            }

        })
    }


    companion object {
        fun getInstance(): RecommondFragment {
            val fragment = RecommondFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


}