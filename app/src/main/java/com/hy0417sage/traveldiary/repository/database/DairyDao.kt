package com.hy0417sage.traveldiary.repository.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hy0417sage.traveldiary.repository.data.DairyEntity

@Dao
interface DairyDao {

    @Query("SELECT * FROM DairyEntity")
    fun wholeDairy(): LiveData<List<DairyEntity>>

    @Insert
    suspend fun insertDiary(diary: DairyEntity)

    @Delete
    suspend fun deleteDiary(diary: DairyEntity)

    @Update
    suspend fun updateDiary(diary: DairyEntity)
}
