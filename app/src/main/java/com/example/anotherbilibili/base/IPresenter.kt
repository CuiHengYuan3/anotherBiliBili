package com.example.anotherbilibili.base


interface IPresenter< in V: IBaseView> {

    fun bindView(mRootView: V)

    fun dropView()

}

