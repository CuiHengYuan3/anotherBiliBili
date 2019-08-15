package com.example.anotherbilibili.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<T : IBaseView> : IPresenter<T> {
    var finalView: T? = null

    private var compositeDisposable = CompositeDisposable()
    override fun bindView(View: T) {
        finalView = View

    }

    override fun dropView() {
        finalView = null
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }


}