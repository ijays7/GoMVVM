package com.ijays.gomvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ijays.gomvvm.model.ArticleModel

/**
 * Created by ijays on 2020/4/12.
 */
@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<ArticleModel>): List<Long>

    @Query("SELECT * FROM t_article_detail")
    suspend fun getArticleList(): List<ArticleModel>
}