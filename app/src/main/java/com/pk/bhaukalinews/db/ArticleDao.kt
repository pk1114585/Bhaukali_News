package com.pk.bhaukalinews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pk.bhaukalinews.model.Article


@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long
    @Query("SELECT * FROM ARTICLES")

    fun getAllArticle(): LiveData <List<Article>>

    @Delete
    suspend fun deleteArticles(article: Article)


}