package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName


data class RecommendBean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("msg")
    val msg: String, // 成功!
    @SerializedName("data")
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("type")
        val type: String, // 41
        @SerializedName("text")
        val tiltle: String, // 健身私教猫腻多，七天拿证，只顾推销，专业教练道其因果！
        @SerializedName("user_id")
        val userId: String, // 17754071
        @SerializedName("name")
        val name: String, // 局长夫人的妹妹
        @SerializedName("screen_name")
        val screenName: String, // 局长夫人的妹妹
        @SerializedName("profile_image")
        val profileImage: String, // http://wimg.spriteapp.cn/profile/large/2016/11/28/583c4ea1f3eb6_mini.jpg
        @SerializedName("created_at")
        val createdAt: String, // 2018-04-21 10:48:02
        @SerializedName("passtime")
        val passtime: String, // 2018-04-21 10:48:02
        @SerializedName("love")
        val love: String, // 429
        @SerializedName("hate")
        val hate: String, // 25
        @SerializedName("comment")
        val comment: String, // 108
        @SerializedName("repost")
        val repost: String, // 81
        @SerializedName("bookmark")
        val bookmark: String, // 51
        @SerializedName("bimageuri")
        val bimageuri: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("status")
        val status: String, // 4
        @SerializedName("theme_id")
        val themeId: String, // 55163
        @SerializedName("theme_name")
        val themeName: String, // 主版块
        @SerializedName("theme_type")
        val themeType: String, // 1
        @SerializedName("videouri")
        val videouri: String, // http://wvideo.spriteapp.cn/video/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.mp4
        @SerializedName("videotime")
        val videotime: Int, // 214
        @SerializedName("original_pid")
        val originalPid: String, // 0
        @SerializedName("cache_version")
        val cacheVersion: Int, // 2
        @SerializedName("playcount")
        val playcount: String, // 25351
        @SerializedName("playfcount")
        val playfcount: String, // 3054
        @SerializedName("cai")
        val cai: String, // 25
        @SerializedName("image1")
        val image1: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("image2")
        val image2: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("is_gif")
        val isGif: Boolean, // false
        @SerializedName("image0")
        val image0: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("image_small")
        val imageSmall: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("cdn_img")
        val cdnImg: String, // http://wimg.spriteapp.cn/picture/2018/0418/f28c34e8-425a-11e8-b880-1866daeb0df1_wpd.jpg
        @SerializedName("width")
        val width: String, // 640
        @SerializedName("height")
        val height: String, // 360
        @SerializedName("tag")
        val tag: String,
        @SerializedName("t")
        val t: Int, // 1524278882
        @SerializedName("ding")
        val ding: String, // 429
        @SerializedName("favourite")
        val favourite: String, // 51
        @SerializedName("create_time")
        val createTime: Any?, // null
        @SerializedName("voiceuri")
        val voiceuri: Any?, // null
        @SerializedName("voicetime")
        val voicetime: Any?, // null
        @SerializedName("voicelength")
        val voicelength: Any?, // null
        @SerializedName("weixin_url")
        val weixinUrl: Any?, // null
        @SerializedName("top_cmt")
        val topCmt: Any?, // null
        @SerializedName("themes")
        val themes: Any? // null
    )
}