package com.example.anotherbilibili.network

import com.example.anotherbilibili.mvp.Bean.AnimationBean
import com.example.anotherbilibili.mvp.Bean.CatalogBean
import com.example.anotherbilibili.mvp.Bean.CatalogDetailBean
import com.example.anotherbilibili.mvp.Bean.RecommendBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //由于有多种api，所以就不要baseUrl了，不方便

    @GET("satinApi?type=4&page=1")
    fun getRecommendData(): Observable<RecommendBean>


    @GET("http://baobab.kaiyanapp.com/api/v4/categories")
    fun getCatalogData(): Observable<ArrayList<CatalogBean>>


    @GET("http://baobab.kaiyanapp.com/api/v3/search")
    fun getCatalogDetailData(@Query("query") query: String): Observable<CatalogDetailBean>


    @GET("https://bangumi.bilibili.com/appindex/follow_index_page")
    fun getAnimationData(
        @Query("appkey") appkey: String, @Query("build") build: String, @Query("mobi_app") mobi_app: String, @Query(
            "platform") platform: String, @Query("ts") ts: String, @Query("sign") sign: String
    ): Observable<AnimationBean>


}