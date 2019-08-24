package com.example.anotherbilibili.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anotherbilibili.MyApplication
import com.example.anotherbilibili.R
import com.example.anotherbilibili.base.baseFragment
import com.example.anotherbilibili.event.ShowLoadingEvent
import com.example.anotherbilibili.mvp.Bean.RankBean
import com.example.anotherbilibili.mvp.contract.RankContract
import com.example.anotherbilibili.mvp.presenter.CatalogPresenter
import com.example.anotherbilibili.mvp.presenter.RankPresenter
import com.example.anotherbilibili.ui.adapter.CatalogAdapter
import com.example.anotherbilibili.ui.adapter.RankAdapter
import kotlinx.android.synthetic.main.fragment_rank.*
import com.lxj.xpopup.interfaces.OnSelectListener
import com.lxj.xpopup.XPopup
import org.greenrobot.eventbus.EventBus

/**
 *
 * 排行fragment
 */
@SuppressLint("WrongConstant")
class RankFragment : baseFragment(), RankContract.view {

    companion object {
        fun getInstance(): RankFragment {
            val fragment = RankFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    var rankAdapter: RankAdapter? = null

    val mPresenter by lazy {
        RankPresenter()
    }
    val linearLayoutManager by lazy {
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }

    var singleRankBean: RankBean? = null
    override fun getLayoutId(): Int = R.layout.fragment_rank

    override fun initView() {
        mPresenter.bindView(this)
        initLisenter()
    }

    override fun lazyLoad() {
        mPresenter.requestHistoryRankData()
    }

    override fun setRankData(rankBean: RankBean) {
        if (rankAdapter == null) {
            re_rank.layoutManager = linearLayoutManager
            singleRankBean = rankBean
            rankAdapter =
                activity?.let {
                    RankAdapter(
                        it,
                        singleRankBean?.itemList as ArrayList<RankBean.Item>,
                        R.layout.item_rank
                    )
                }
            re_rank.adapter = rankAdapter
        } else {
            singleRankBean = rankBean
            rankAdapter!!.mData =
                singleRankBean?.itemList as ArrayList<RankBean.Item>
            rankAdapter?.notifyDataSetChanged()

        }

    }


    fun initLisenter() {
        ll_change_rank.setOnClickListener {
            showChangeRankDialog()
        }
    }

    override fun showIsLoading() {
        EventBus.getDefault().post(ShowLoadingEvent(true))

    }

    override fun removeLoading() {
        EventBus.getDefault().post(ShowLoadingEvent(false))

    }

    fun showChangeRankDialog() {
        XPopup.Builder(context)
            .atView(ll_change_rank).hasShadowBg(false)  // 依附于所点击的View，内部会自动判断在上方或者下方显示
            .asAttachList(
                arrayOf("周排行", "月排行", "总排行"),
                intArrayOf(R.mipmap.ic_category_promo, R.mipmap.ic_category_t1, R.mipmap.ic_category_t5)
            ) { position, text ->
                when (position) {
                    0 -> {
                        tv_rank.text = "周排行"
                        mPresenter.requestWeekRankData()
                    }
                    1 -> {
                        tv_rank.text = "月排行"
                        mPresenter.requestMonthRankData()
                    }
                    2 -> {
                        tv_rank.text = "总排行"
                        mPresenter.requestWeekRankData()
                    }
                }


            }
            .show()
    }
}