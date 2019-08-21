package com.example.anotherbilibili.mvp.Bean

/*这个bean类为不同的视频源中提取的共有的部分，
用来云端存储的*/
data class ExtractBean(
    val videoName: String?,
    val videoUrl: String?,
    val autherName: String?,
    val autherImaeg: String?,
    val videoPicUrl: String?,
    var commendList: MutableList<CommendBean>? =ArrayList(),//喜欢，收藏数默认为零
    var loveNumber: Int? = 0,
    var collectNumber: Int? = 0
)

data class CommendBean(val userPic:String?=null,val userName: String?, val commendText: String?)//评论类

