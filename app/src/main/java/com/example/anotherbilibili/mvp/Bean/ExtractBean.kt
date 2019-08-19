package com.example.anotherbilibili.mvp.Bean

/*这个bean类为不同的视频源中提取的共有的部分，
用来云端存储的*/
data class ExtractBean(
    val videoName: String?,
    val videoUrl: String?,
    val autherName: String?,
    val autherImaeg: String?,
    val videoPicUrl: String?,
    var commendList: MutableList<CommendBean>
)

data class CommendBean(val userName: String, val commendText: String)//评论类

