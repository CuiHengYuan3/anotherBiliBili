package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName


/**
 * 追番页面的资讯bean
 */
data class InformationData(
    @SerializedName("code")
    val code: Int, // 0
    @SerializedName("message")
    val message: String, // success
    @SerializedName("result")
    val result: List<Result>
) {
    data class Result(
        @SerializedName("cover")
        val cover: String, // http://i0.hdslb.com/bfs/bangumi/9d6072e87ba9034a22e4cc0c86f922fe1b991d71.jpg
        @SerializedName("desc")
        val desc: String?, // 这只旱獭性格非常的懒，拖延症晚期，想减肥又爱喝可乐，时常纠结又放飞自我，脑洞大开还会突然加速。
        @SerializedName("id")
        val id: Int, // 44680
        @SerializedName("is_new")
        val isNew: Int, // 0
        @SerializedName("link")
        val link: String, // https://www.bilibili.com/blackboard/topic/activity-PCgiQMkYW.html
        @SerializedName("title")
        val title: String, // 汉化日记——这是一个万物皆可汉子化的世界
        @SerializedName("type")
        val type: Int, // 1
        @SerializedName("wid")
        val wid: Int, // 59
        @SerializedName("cursor")
        val cursor: Double // 1.564848000873E12
    )
}