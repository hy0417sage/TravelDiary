package com.hy0417sage.traveldiary.repository.impl

import com.hy0417sage.traveldiary.repository.DairyRepository
import com.hy0417sage.traveldiary.repository.database.DairyDao
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import javax.inject.Inject

class DairyRepositoryImpl @Inject constructor(private val dairyDao: DairyDao) : DairyRepository {

    override fun wholeDiary() = dairyDao.wholeDairy()

    override suspend fun insertDiary(dairyEntity: DairyEntity) {
        dairyDao.insertDiary(dairyEntity)
    }

    override suspend fun deleteDiary(dairyEntity: DairyEntity) {
        dairyDao.deleteDiary(dairyEntity)
    }

    override suspend fun updateDiary(dairyEntity: DairyEntity) {
        dairyDao.updateDiary(dairyEntity)
    }
}