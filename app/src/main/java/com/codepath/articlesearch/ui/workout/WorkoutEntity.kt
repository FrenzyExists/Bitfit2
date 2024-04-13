package com.codepath.articlesearch.ui.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "bitfit_table")
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true) val id : Long = 0,
    @ColumnInfo(name = "title") val exTitle: String?,
    @ColumnInfo(name = "reps") val reps: String?,
    @ColumnInfo(name = "date") val date: String
): Serializable