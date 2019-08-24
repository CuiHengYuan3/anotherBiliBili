package com.example.anotherbilibili.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * 获取retrofit的单例类
 */

object RetrofitManager {
    val service: ApiService by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        getRetrofit().create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .build()
    }

    private fun getRetrofit(): Retrofit {
        // 获取retrofit的实例
        return Retrofit.Builder()
            .baseUrl(UrlFixed.RecommendUrl) //自己配置
            .client(getOkHttpClient()).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}