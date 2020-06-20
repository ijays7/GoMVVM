package com.ijays.gomvvm.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ijays.gomvvm.model.ArticleModel

/**
 * Created by ijays on 2020/4/2.
 */
@Database(entities = [ArticleModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Get article DAO
     */
    abstract fun articleDao(): ArticleDao

    companion object {
        private const val databaseName = "app-db"

        /**
         * build default room instance
         */
        fun buildDefault(context: Context) = Room.databaseBuilder(
            context, AppDatabase::class.java,
            databaseName
        ).build()
    }

}