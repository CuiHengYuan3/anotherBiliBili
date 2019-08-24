package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName

/**
 * 追番界面的bean类之一
 */
data class AnimationBean(
    @SerializedName("code")
    val code: Int, // 0
    @SerializedName("message")
    val message: String, // success
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("ad")
        val ad: List<Any>,
        @SerializedName("recommend_cn")
        val recommendCn: RecommendCn,
        @SerializedName("recommend_jp")
        val recommendJp: RecommendJp,
        @SerializedName("recommend_review")
        val recommendReview: List<Any>,
        @SerializedName("timeline")
        val timeline: List<Timeline>
    ) {
        data class RecommendCn(
            @SerializedName("foot")
            val foot: List<Foot>,
            @SerializedName("recommend")
            val recommend: List<Recommend>
        ) {
            data class Recommend(
                @SerializedName("cover")
                val cover: String, // http://i0.hdslb.com/bfs/bangumi/6c48ab5eb293218daf369f6c6763ca4c8770a0c2.jpg
                @SerializedName("favourites")
                val favourites: String, // 334847
                @SerializedName("is_auto")
                val isAuto: Int, // 0
                @SerializedName("is_finish")
                val isFinish: Int, // 0
                @SerializedName("is_started")
                val isStarted: Int, // 1
                @SerializedName("last_time")
                val lastTime: Int, // 1566100800
                @SerializedName("newest_ep_index")
                val newestEpIndex: String, // 5
                @SerializedName("pub_time")
                val pubTime: Int, // 1564243201
                @SerializedName("season_id")
                val seasonId: Int, // 27933
                @SerializedName("season_status")
                val seasonStatus: Int, // 13
                @SerializedName("title")
                val title: String, // 少女前线 人形小剧场
                @SerializedName("total_count")
                val totalCount: Int, // 24
                @SerializedName("watching_count")
                val watchingCount: Int, // 0
                @SerializedName("wid")
                val wid: Int // 84
            )

            data class Foot(
                @SerializedName("cover")
                val cover: String, // http://i0.hdslb.com/bfs/bangumi/34bef4665cfa283a58c7da913f5d3619a3295744.jpg
                @SerializedName("desc")
                val desc: String, // 为了答谢各位长久以来对国产动画的支持，我们特意制作了国产动画专属挂件！速度围观啦~
                @SerializedName("id")
                val id: Int, // 45850
                @SerializedName("is_auto")
                val isAuto: Int, // 1
                @SerializedName("link")
                val link: String, // https://www.bilibili.com/blackboard/topic/activity-RLa-ZPAev.html
                @SerializedName("title")
                val title: String, // 国产动画回馈活动3.0开启！
                @SerializedName("wid")
                val wid: Int // 59
            )
        }

        data class Timeline(
            @SerializedName("area_id")
            val areaId: Int, // 2
            @SerializedName("cover")
            val cover: String, // http://i0.hdslb.com/bfs/bangumi/4b722352adf7e6261e779fb59ab8e6bdb3939777.png
            @SerializedName("delay")
            val delay: Int, // 0
            @SerializedName("ep_id")
            val epId: Int, // 278870
            @SerializedName("favorites")
            val favorites: Int, // 5482
            @SerializedName("follow")
            val follow: Int, // 0
            @SerializedName("is_published")
            val isPublished: Int, // 1
            @SerializedName("order")
            val order: Int, // 4
            @SerializedName("pub_date")
            val pubDate: String, // 2019-08-21
            @SerializedName("pub_index")
            val pubIndex: String, // 第4话
            @SerializedName("pub_time")
            val pubTime: String, // 02:05
            @SerializedName("pub_ts")
            val pubTs: Int, // 1566324300
            @SerializedName("season_id")
            val seasonId: Int, // 28014
            @SerializedName("season_status")
            val seasonStatus: Int, // 2
            @SerializedName("square_cover")
            val squareCover: String, // http://i0.hdslb.com/bfs/bangumi/1f8d25501ef6e842801abe2b475a531ca2f97685.jpg
            @SerializedName("title")
            val title: String // TRY KNIGHTS（僅限台灣地區）
        )

        data class RecommendJp(
            @SerializedName("foot")
            val foot: List<Foot>,
            @SerializedName("recommend")
            val recommend: List<RecommendCn.Recommend>
        ) {
            data class Foot(
                @SerializedName("cover")
                val cover: String, // http://i0.hdslb.com/bfs/bangumi/83fb36258cef00f3e809b6eea65e2388d03a0880.jpg
                @SerializedName("id")
                val id: Int, // 45497
                @SerializedName("is_auto")
                val isAuto: Int, // 1
                @SerializedName("link")
                val link: String, // https://www.bilibili.com/blackboard/topic/activity-A64dxJZE_.html
                @SerializedName("title")
                val title: String, // 【资讯档】2019年第33周
                @SerializedName("wid")
                val wid: Int // 78
            )

            data class Recommend(
                @SerializedName("cover")
                val cover: String, // http://i0.hdslb.com/bfs/bangumi/4f3302a21bc658addbf9220e20ae71e18474956d.jpg
                @SerializedName("favourites")
                val favourites: String, // 1454900
                @SerializedName("is_auto")
                val isAuto: Int, // 0
                @SerializedName("is_finish")
                val isFinish: Int, // 0
                @SerializedName("is_started")
                val isStarted: Int, // 1
                @SerializedName("last_time")
                val lastTime: Int, // 1565974800
                @SerializedName("newest_ep_index")
                val newestEpIndex: String, // 6
                @SerializedName("pub_time")
                val pubTime: Int, // 1562346000
                @SerializedName("season_id")
                val seasonId: Int, // 27959
                @SerializedName("season_status")
                val seasonStatus: Int, // 13
                @SerializedName("title")
                val title: String, // 炎炎消防队
                @SerializedName("total_count")
                val totalCount: Int, // -1
                @SerializedName("watching_count")
                val watchingCount: Int, // 0
                @SerializedName("wid")
                val wid: Int // 82
            )
        }
    }
}