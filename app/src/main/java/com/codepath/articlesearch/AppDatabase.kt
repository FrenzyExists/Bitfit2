package com.codepath.articlesearch

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codepath.articlesearch.ui.workout.WorkoutEntity
import com.codepath.articlesearch.ui.workout.workoutDAO

@Database(entities = [WorkoutEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun workoutDao() : workoutDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it}
            }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "BitFit_db"
            ).build()
    }
}