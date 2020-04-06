package com.ijays.gomvvm.model

/**
 * Created by ijays on 2020/4/5.
 */
data class ArticleListModel(
    val curPage: Int,
    val size: Int,
    val total: Int,
    val offset: Int,
    val pageCount: Int,
    val over: Boolean,
    val datas: List<ArticleModel>
)