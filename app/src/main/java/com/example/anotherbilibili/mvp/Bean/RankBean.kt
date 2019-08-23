package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName


data class RankBean(
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("count")
    val count: Int, // 10
    @SerializedName("total")
    val total: Int, // 0
    @SerializedName("nextPageUrl")
    val nextPageUrl: Any?, // null
    @SerializedName("adExist")
    val adExist: Boolean // false
) {
    data class Item(
        @SerializedName("type")
        val type: String, // video
        @SerializedName("data")
        val `data`: Data,
        @SerializedName("id")
        val id: Int, // 0
        @SerializedName("adIndex")
        val adIndex: Int, // -1
        @SerializedName("tag")
        val tag: Any? // null
    ) {
        data class Data(
            @SerializedName("dataType")
            val dataType: String, // VideoBeanForClient
            @SerializedName("id")
            val id: Int, // 7626
            @SerializedName("title")
            val title: String, // 第一视角的「部落冲突」
            @SerializedName("description")
            val description: String, // 「部落冲突」（Clash of Clans）是芬兰游戏公司 Supercell 所推出的策略类手机游戏。这个 360°的视频让玩家比起上帝视角更有代入感，来一起和弓箭手红毛妹子守城吧~ From Clash of Clans
            @SerializedName("library")
            val library: String, // DAILY
            @SerializedName("tags")
            val tags: List<Tag>,
            @SerializedName("consumption")
            val consumption: Consumption,
            @SerializedName("resourceType")
            val resourceType: String, // video
            @SerializedName("slogan")
            val slogan: Any?, // null
            @SerializedName("provider")
            val provider: Provider,
            @SerializedName("category")
            val category: String, // 游戏
            @SerializedName("author")
            val author: Author,
            @SerializedName("cover")
            val cover: Cover,
            @SerializedName("playUrl")
            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=7626&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss
            @SerializedName("thumbPlayUrl")
            val thumbPlayUrl: Any?, // null
            @SerializedName("duration")
            val duration: Int, // 83
            @SerializedName("webUrl")
            val webUrl: WebUrl,
            @SerializedName("releaseTime")
            val releaseTime: Long, // 1465056000000
            @SerializedName("playInfo")
            val playInfo: List<PlayInfo>,
            @SerializedName("campaign")
            val campaign: Any?, // null
            @SerializedName("waterMarks")
            val waterMarks: Any?, // null
            @SerializedName("ad")
            val ad: Boolean, // false
            @SerializedName("adTrack")
            val adTrack: Any?, // null
            @SerializedName("type")
            val type: String, // PANORAMIC
            @SerializedName("titlePgc")
            val titlePgc: Any?, // null
            @SerializedName("descriptionPgc")
            val descriptionPgc: Any?, // null
            @SerializedName("remark")
            val remark: Any?, // null
            @SerializedName("ifLimitVideo")
            val ifLimitVideo: Boolean, // false
            @SerializedName("searchWeight")
            val searchWeight: Int, // 0
            @SerializedName("idx")
            val idx: Int, // 0
            @SerializedName("shareAdTrack")
            val shareAdTrack: Any?, // null
            @SerializedName("favoriteAdTrack")
            val favoriteAdTrack: Any?, // null
            @SerializedName("webAdTrack")
            val webAdTrack: Any?, // null
            @SerializedName("date")
            val date: Long, // 1465056000000
            @SerializedName("promotion")
            val promotion: Any?, // null
            @SerializedName("label")
            val label: Label,
            @SerializedName("labelList")
            val labelList: List<Label>,
            @SerializedName("descriptionEditor")
            val descriptionEditor: String, // 「部落冲突」（Clash of Clans）是芬兰游戏公司 Supercell 所推出的策略类手机游戏。这个 360°的视频让玩家比起上帝视角更有代入感，来一起和弓箭手红毛妹子守城吧~ From Clash of Clans
            @SerializedName("collected")
            val collected: Boolean, // false
            @SerializedName("played")
            val played: Boolean, // false
            @SerializedName("subtitles")
            val subtitles: List<Any>,
            @SerializedName("lastViewTime")
            val lastViewTime: Any?, // null
            @SerializedName("playlists")
            val playlists: Any?, // null
            @SerializedName("src")
            val src: Any? // null
        ) {
            data class Cover(
                @SerializedName("feed")
                val feed: String, // http://img.kaiyanapp.com/f1216a3f455110c65ac90d833ad11207.jpeg?imageMogr2/quality/100
                @SerializedName("detail")
                val detail: String, // http://img.kaiyanapp.com/f1216a3f455110c65ac90d833ad11207.jpeg?imageMogr2/quality/100
                @SerializedName("blurred")
                val blurred: String, // http://img.kaiyanapp.com/24389598abf3f678cf79f3fed7daafd4.jpeg?imageMogr2/quality/100
                @SerializedName("sharing")
                val sharing: Any?, // null
                @SerializedName("homepage")
                val homepage: Any? // null
            )


            data class PlayInfo(
                @SerializedName("height")
                val height: Int, // 640
                @SerializedName("width")
                val width: Int, // 1280
                @SerializedName("urlList")
                val urlList: List<Url>,
                @SerializedName("name")
                val name: String, // 高清
                @SerializedName("type")
                val type: String, // high
                @SerializedName("url")
                val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=7626&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss
            ) {
                data class Url(
                    @SerializedName("name")
                    val name: String, // ucloud
                    @SerializedName("url")
                    val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=7626&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss
                    @SerializedName("size")
                    val size: Int // 11917564
                )
            }

            data class Author(
                @SerializedName("id")
                val id: Int, // 2168
                @SerializedName("icon")
                val icon: String, // http://img.kaiyanapp.com/2c908f8a57243310556464ca12a61051.png?imageMogr2/quality/60/format/jpg
                @SerializedName("name")
                val name: String, // 开眼游戏精选
                @SerializedName("description")
                val description: String, // 欢迎来到惊险刺激的新世界
                @SerializedName("link")
                val link: String,
                @SerializedName("latestReleaseTime")
                val latestReleaseTime: Long, // 1562720419000
                @SerializedName("videoNum")
                val videoNum: Int, // 187
                @SerializedName("adTrack")
                val adTrack: Any?, // null
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("shield")
                val shield: Shield,
                @SerializedName("approvedNotReadyVideoCount")
                val approvedNotReadyVideoCount: Int, // 0
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("recSort")
                val recSort: Int, // 0
                @SerializedName("expert")
                val expert: Boolean // false
            ) {
                data class Follow(
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("itemId")
                    val itemId: Int, // 2168
                    @SerializedName("followed")
                    val followed: Boolean // false
                )

                data class Shield(
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("itemId")
                    val itemId: Int, // 2168
                    @SerializedName("shielded")
                    val shielded: Boolean // false
                )
            }

            data class Provider(
                @SerializedName("name")
                val name: String, // YouTube
                @SerializedName("alias")
                val alias: String, // youtube
                @SerializedName("icon")
                val icon: String // http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
            )

            data class WebUrl(
                @SerializedName("raw")
                val raw: String, // http://www.eyepetizer.net/detail.html?vid=7626
                @SerializedName("forWeibo")
                val forWeibo: String // http://wandou.im/2a9okf
            )

            data class Tag(
                @SerializedName("id")
                val id: Int, // 658
                @SerializedName("name")
                val name: String, // 360°全景
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://tag/658/?title=360%C2%B0%E5%85%A8%E6%99%AF
                @SerializedName("desc")
                val desc: String?, // 欢迎来到惊险刺激的新世界
                @SerializedName("bgPicture")
                val bgPicture: String, // http://img.kaiyanapp.com/aa03a56a70499a0f37e2705767c9bbdb.png?imageMogr2/quality/60/format/jpg
                @SerializedName("headerImage")
                val headerImage: String, // http://img.kaiyanapp.com/aa03a56a70499a0f37e2705767c9bbdb.png?imageMogr2/quality/60/format/jpg
                @SerializedName("tagRecType")
                val tagRecType: String, // NORMAL
                @SerializedName("communityIndex")
                val communityIndex: Int, // 0
                @SerializedName("adTrack")
                val adTrack: Any?, // null
                @SerializedName("childTagList")
                val childTagList: Any?, // null
                @SerializedName("childTagIdList")
                val childTagIdList: Any? // null
            )

            data class Label(
                @SerializedName("text")
                val text: String, // 360°全景
                @SerializedName("card")
                val card: String, // 360°全景
                @SerializedName("detail")
                val detail: String // 360°全景
            )

            data class Consumption(
                @SerializedName("collectionCount")
                val collectionCount: Int, // 22247
                @SerializedName("shareCount")
                val shareCount: Int, // 52104
                @SerializedName("replyCount")
                val replyCount: Int // 331
            )
        }
    }
}