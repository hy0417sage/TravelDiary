package com.hy0417sage.traveldiary.repository

import androidx.lifecycle.LiveData
import com.hy0417sage.traveldiary.repository.data.DairyEntity

interface DairyRepository {
    suspend fun insertDiary(dairy: DairyEntity)
    suspend fun deleteDiary(dairy: DairyEntity)
    suspend fun updateDiary(dairy: DairyEntity)
    fun wholeDiary(): LiveData<List<DairyEntity>>
}