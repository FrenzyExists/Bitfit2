package com.codepath.articlesearch.ui.workout

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface workoutDAO {
    @Query("SELECT * FROM bitfit_table")
    fun getAll(): Flow<List<WorkoutEntity>>

    @Insert
    fun insertAll(bitfitItems: List<WorkoutEntity>)

    @Insert
    fun insert(bitfitItem: WorkoutEntity)

    @Query("DELETE FROM bitfit_table")
    fun deleteAll()
}