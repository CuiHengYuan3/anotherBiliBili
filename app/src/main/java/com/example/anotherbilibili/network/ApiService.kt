package com.example.anotherbilibili.network

import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("satinApi?type=4&page=1")
    fun getRecommendData(): Observable<RecommendBean>


    @GET("http://baobab.kaiyanapp.com/api/v4/categories")
    fun getCatalogData(): Observable<ArrayList<CatalogBean>>


    @GET("http://baobab.kaiyanapp.com/api/v3/search")
    fun getCatalogDetailData(@Query("query") query: String ): Observable<CatalogDetailBean>



}