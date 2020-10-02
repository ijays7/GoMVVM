package com.ijays.gomvvm.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Created by ijays on 2020/4/5.
 */
@Entity(tableName = "t_article_detail")
@Serializable
data class ArticleModel(
    @PrimaryKey
    val id: Int,
    val originId: Int? = null,
    val title: String,
    val chapterId: Int,
    val chapterName: String,
    val envelopePic: String,
    val link: String,
    val author: String?,
    val origin: String,
    val publishTime: Long,
    val zan: Int,
    val desc: String?,
    val visible: Int,
    val niceDate: String,
    val niceShareDate: String,
    val courseId: Int,
    var collect: Boolean,
    val apkLink: String,
    val projectLink: String,
    val superChapterId: Int,
    val superChapterName: String?,
    val type: Int,
    val fresh: Boolean,
    val audit: Int,
    val prefix: String,
    val selfVisible: Int,
    val shareDate: Long,
    val shareUser: String,
//    val tags: Any,
    val userId: Int
)