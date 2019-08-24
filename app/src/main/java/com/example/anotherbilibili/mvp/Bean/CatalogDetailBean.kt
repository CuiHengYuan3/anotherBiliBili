package com.example.anotherbilibili.mvp.Bean
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * 具体分区的Bean类
 */
data class CatalogDetailBean(
    @SerializedName("itemList")
    var itemList: List<Item>,
    @SerializedName("count")
    val count: Int, // 17
    @SerializedName("total")
    val total: Int, // 1
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v3/search?start=10&num=10&query=%E8%90%8C%E5%AE%A0
    @SerializedName("adExist")
    val adExist: Boolean // false
) :Serializable{
    data class Item(//一个bean有一个item数组
        @SerializedName("type")
        val type: String, // followCard
        @SerializedName("data")
        val `data`: Data,
        @SerializedName("id")
        val id: Int, // 0
        @SerializedName("adIndex")
        val adIndex: Int, // -1
        @SerializedName("tag")
        val tag: Any? // null
    ) :Serializable{
        data class Data(//一个bean有一个Data数组
            @SerializedName("dataType")
            val dataType: String, // FollowCard
            @SerializedName("header")
            val header: Header,
            @SerializedName("content")
            val content: Content,//一个bean有一个Content数组
            @SerializedName("adTrack")
            val adTrack: Any? // null
        ) :Serializable{
            data class Header(
                @SerializedName("id")
                val id: Int, // 48309
                @SerializedName("title")
                val title: String, // 柴犬Haru
                @SerializedName("font")
                val font: Any?, // null
                @SerializedName("subTitle")
                val subTitle: Any?, // null
                @SerializedName("subTitleFont")
                val subTitleFont: Any?, // null
                @SerializedName("textAlign")
                val textAlign: String, // left
                @SerializedName("cover")
                val cover: Any?, // null
                @SerializedName("label")
                val label: Any?, // null
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/1381/?title=%E6%9F%B4%E7%8A%ACHaru&userType=PGC&tabIndex=1
                @SerializedName("labelList")
                val labelList: Any?, // null
                @SerializedName("rightText")
                val rightText: Any?, // null
                @SerializedName("icon")
                val icon: String, // http://img.kaiyanapp.com/014b8ee0bc346a4978d6ea76c6d07a72.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("description")
                val description: String, // #萌宠
                @SerializedName("time")
                val time: Long, // 1504400902000
                @SerializedName("showHateVideo")
                val showHateVideo: Boolean // false
            ):Serializable




            data class Content(
                @SerializedName("type")
                val type: String, // video
                @SerializedName("data")
                val `data`: Data,
                @SerializedName("tag")
                val tag: Any?, // null
                @SerializedName("id")
                val id: Int, // 0
                @SerializedName("adIndex")
                val adIndex: Int // -1
            ) :Serializable{
                data class Data(
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("id")
                    val id: Int, // 48309
                    @SerializedName("title")
                    val title: String, // 萌萌柴犬如何用行动证明爱意//视频标题
                    @SerializedName("description")
                    val description: String, // 萌哭！
                    @SerializedName("library")
                    val library: String, // NOT_RECOMMEND
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
                    val category: String, // 萌宠
                    @SerializedName("author")
                    val author: Author,//这个里面的icon是作者图标，name是作者名字
                    @SerializedName("cover")
                    val cover: Cover,//这个里面的feed是视频图片
                    @SerializedName("playUrl")
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=48309&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss
                    @SerializedName("thumbPlayUrl")
                    val thumbPlayUrl: Any?, // null
                    @SerializedName("duration")
                    val duration: Int, // 76
                    @SerializedName("webUrl")
                    val webUrl: WebUrl,
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1504400902000
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
                    val type: String, // NORMAL
                    @SerializedName("titlePgc")
                    val titlePgc: String, // 萌萌柴犬如何用行动证明爱意
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String, // 萌哭！
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
                    val date: Long, // 1504400902000
                    @SerializedName("promotion")
                    val promotion: Any?, // null
                    @SerializedName("label")
                    val label: Any?, // null
                    @SerializedName("labelList")
                    val labelList: List<Any>,
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String,
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
                ) :Serializable{
                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 8
                        @SerializedName("shareCount")
                        val shareCount: Int, // 42
                        @SerializedName("replyCount")
                        val replyCount: Int // 1
                    ):Serializable

                    data class WebUrl(
                        @SerializedName("raw")
                        val raw: String, // http://www.eyepetizer.net/detail.html?vid=48309
                        @SerializedName("forWeibo")
                        val forWeibo: String // http://wandou.im/3o9j8r
                    ):Serializable

                    data class PlayInfo(
                        @SerializedName("height")
                        val height: Int, // 720
                        @SerializedName("width")
                        val width: Int, // 1280
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("name")
                        val name: String, // 高清
                        @SerializedName("type")
                        val type: String, // high
                        @SerializedName("url")
                        val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=48309&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss
                    ) :Serializable{
                        data class Url(
                            @SerializedName("name")
                            val name: String, // ucloud
                            @SerializedName("url")
                            val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=48309&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss
                            @SerializedName("size")
                            val size: Int // 7732131
                        ):Serializable
                    }

                    data class Tag(
                        @SerializedName("id")
                        val id: Int, // 32
                        @SerializedName("name")
                        val name: String, // 萌宠
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://tag/32/?title=%E8%90%8C%E5%AE%A0
                        @SerializedName("desc")
                        val desc: String, // 来自汪星、喵星、蠢萌星的你
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/bd689302a738a5d2156243a2b74f15d1.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/1ea685a0d2757701741a4a9be0f7e269.jpeg?imageMogr2/quality/60/format/jpg
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
                    ):Serializable

                    data class Author(
                        @SerializedName("id")
                        val id: Int, // 1381
                        @SerializedName("icon")
                        val icon: String, // http://img.kaiyanapp.com/014b8ee0bc346a4978d6ea76c6d07a72.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("name")
                        val name: String?, // 柴犬Haru
                        @SerializedName("description")
                        val description: String, // 与日本柴犬Haru一起生活，她很少吠叫，平静，积极，可爱:)
                        @SerializedName("link")
                        val link: String,
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1563207581000
                        @SerializedName("videoNum")
                        val videoNum: Int, // 150
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
                    ) :Serializable{
                        data class Shield(
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("itemId")
                            val itemId: Int, // 1381
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        ):Serializable

                        data class Follow(
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("itemId")
                            val itemId: Int, // 1381
                            @SerializedName("followed")
                            val followed: Boolean // false
                        ):Serializable
                    }

                    data class Cover(
                        @SerializedName("feed")
                        val feed: String, // http://img.kaiyanapp.com/9a49368fb7f22ee5b8a16f3468193ead.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("detail")
                        val detail: String, // http://img.kaiyanapp.com/9a49368fb7f22ee5b8a16f3468193ead.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("blurred")
                        val blurred: String, // http://img.kaiyanapp.com/29e3002a8299f97edef4a8484b578925.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("sharing")
                        val sharing: Any?, // null
                        @SerializedName("homepage")
                        val homepage: Any? // null
                    ):Serializable

                    data class Provider(
                        @SerializedName("name")
                        val name: String, // 定制来源
                        @SerializedName("alias")
                        val alias: String, // CustomSrc
                        @SerializedName("icon")
                        val icon: String
                    ):Serializable
                }
            }
        }
    }
}