package com.example.anotherbilibili.base

import io.reactivex.*
import org.reactivestreams.Publisher

abstract class BaseScheduler<T>(
    val subscribeOnScheduler: Scheduler,
    val observeOnScheduler: Scheduler
) : ObservableTransformer<T, T>, FlowableTransformer<T, T> {

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
            .observeOn(observeOnScheduler)
    }


}
