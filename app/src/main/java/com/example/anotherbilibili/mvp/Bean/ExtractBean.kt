package com.example.anotherbilibili.mvp.Bean

/**
 * 这个bean类为不同的视频源中提取的共有的部分，
 *用来云端存储管理
 *
 *
 */
data class ExtractBean(
    val videoName: String?,//视频名称
    val videoUrl: String?,//视频url
    val autherName: String?,//作者名称
    val autherImaeg: String?,//作者头像
    val videoPicUrl: String?,//视频cover
    var commendList: MutableList<CommendBean>? = ArrayList(),//喜欢，收藏数默认为零
    var loveNumber: Int? = 0,//喜欢个数
    var collectNumber: Int? = 0,//收藏个数
    var danmuList: MutableList<String>? = ArrayList(),//评论列表
    var publishTime: String? = null//发布时间
)

data class CommendBean(val userPic: String? = null, val userName: String?, val commendText: String?)//评论类

