package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CatalogBean(
    @SerializedName("id")
    val id: Int, // 26
    @SerializedName("name")
    val name: String, // 萌宠
    @SerializedName("description")
    val description: String, // 来自汪星、喵星、蠢萌星的你
    @SerializedName("bgPicture")
    val bgPicture: String, // http://img.kaiyanapp.com/d93e1ea7470008375ea4462ec752b5b7.png?imageMogr2/quality/60/format/jpg
    @SerializedName("bgColor")
    val bgColor: String,
    @SerializedName("headerImage")
    val headerImage: String, // http://img.kaiyanapp.com/44d902292741e4d385f39df832446a48.png
    @SerializedName("defaultAuthorId")
    val defaultAuthorId: Int, // 2169
    @SerializedName("tagId")
    val tagId: Int, // 32
    @SerializedName("alias")
    val alias: Any? // null
):Serializable