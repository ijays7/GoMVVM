package com.ijays.gomvvm.di

import android.content.Context
import com.ijays.gomvvm.db.AppDatabase
import com.ijays.gomvvm.db.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by ijays on 2020/8/5.
 */
@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildDefault(context)
    }

    @Provides
    fun provideArticleDao(database: AppDatabase): ArticleDao {
        return database.articleDao()
    }
}