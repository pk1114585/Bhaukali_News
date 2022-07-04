package com.pk.bhaukalinews.db

import android.content.Context
import androidx.room.*
import com.pk.bhaukalinews.model.Article
import kotlinx.coroutines.InternalCoroutinesApi

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converter::class)

abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao() : ArticleDao

    companion object{
        @Volatile
        private var instant: ArticleDatabase?=null
        private var Lock=Any()

        @InternalCoroutinesApi
        operator fun invoke(context: Context)= instant?: synchronized(Lock){
            instant?:createDatabase(context).also{ instant= it}

        }
        private fun createDatabase(context: Context)= Room.databaseBuilder(context.applicationContext,ArticleDatabase::class.java,"article_db.db")
            .build()

    }
}