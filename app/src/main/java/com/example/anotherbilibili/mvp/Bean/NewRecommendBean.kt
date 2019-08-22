package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class NewRecommendBean(
    @SerializedName("code")
    val code: Int, // 200
    @SerializedName("message")
    val message: String, // 成功!
    @SerializedName("result")
    val result: List<Result>
) :Serializable{
    data class Result(
        @SerializedName("sid")
        val sid: String, // 29721062
        @SerializedName("text")
        val tiltle: String, // 今天想做一回霸道总裁！ 唉~
        @SerializedName("type")
        val type: String, // video
        @SerializedName("thumbnail")
        val bimageuri: String, // http://wimg.spriteapp.cn/picture/2019/0821/5d5c5fc18e68b_wpd.jpg
        @SerializedName("video")
        val videouri: String, // http://wvideo.spriteapp.cn/video/2019/0821/5d5c5fc18e68b_wpd.mp4
        @SerializedName("up")
        val up: String, // 201
        @SerializedName("down")
        val down: String, // 12
        @SerializedName("forward")
        val forward: String, // 5
        @SerializedName("comment")
        val comment: String, // 23
        @SerializedName("uid")
        val uid: String, // 23123034
        @SerializedName("name")
        val name: String, // 暗凄凉
        @SerializedName("header")
        val profileImage: String, // http://wimg.spriteapp.cn/profile/large/2019/07/03/5d1c79de3f558_mini.jpg
        @SerializedName("passtime")
        val passtime: String, // 2019-08-21 23:01:02
        @SerializedName("top_comments_content")
        val topCommentsContent: String?, // 旦总还是这么的有深意！
        @SerializedName("top_comments_voiceuri")
        val topCommentsVoiceuri: String?,
        @SerializedName("top_comments_uid")
        val topCommentsUid: String?, // 8371825
        @SerializedName("top_comments_name")
        val topCommentsName: String?, // 额Lc
        @SerializedName("top_comments_header")
        val topCommentsHeader: String?, // http://qzapp.qlogo.cn/qzapp/100336987/92E0A678A2B7DFE0D3554F60A9333158/100
        @SerializedName("images")
        val images: Any? // null
    ):Serializable
}