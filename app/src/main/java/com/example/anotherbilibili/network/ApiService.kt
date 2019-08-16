package com.example.anotherbilibili.network

import com.example.anotherbilibili.mvp.Bean.RecommendBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("satinApi?type=4&page=1")
    fun getRecommendData(): Observable<RecommendBean>


}