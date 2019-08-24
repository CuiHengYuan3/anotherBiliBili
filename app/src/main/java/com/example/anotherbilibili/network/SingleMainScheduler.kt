package com.example.anotherbilibili.network

import com.example.anotherbilibili.base.BaseScheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SingleMainScheduler<T> private constructor() : BaseScheduler<T>(Schedulers.single(), AndroidSchedulers.mainThread())