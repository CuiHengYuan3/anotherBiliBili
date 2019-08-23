package com.example.anotherbilibili.network

import com.example.anotherbilibili.mvp.Bean.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import kotlin.collections.ArrayList

interface ApiService {

    //由于有多种api，所以就不要baseUrl了，不方便

    //这个已经不行了
    @GET("satinApi?type=4&page=1")
    fun getRecommendData(): Observable<RecommendBean>

    @GET("https://api.apiopen.top/getJoke")
    fun getNewRecommendData(@Query("page") query: Int, @Query("count") count: Int, @Query("type") type: String): Observable<NewRecommendBean>


    @GET("http://baobab.kaiyanapp.com/api/v4/categories")
    fun getCatalogData(): Observable<ArrayList<CatalogBean>>


    @GET("http://baobab.kaiyanapp.com/api/v3/search")
    fun getCatalogDetailData(@Query("query") query: String): Observable<CatalogDetailBean>


    @GET("https://bangumi.bilibili.com/appindex/follow_index_page")
    fun getAnimationData(
        @Query("appkey") appkey: String, @Query("build") build: String, @Query("mobi_app") mobi_app: String, @Query(
            "platform"
        ) platform: String, @Query("ts") ts: String, @Query("sign") sign: String
    ): Observable<AnimationBean>


    @GET("http://baobab.kaiyanapp.com/api/v4/rankList/videos")
    fun getRankData(@Query("strategy") strategy:String  ): Observable<RankBean>




}