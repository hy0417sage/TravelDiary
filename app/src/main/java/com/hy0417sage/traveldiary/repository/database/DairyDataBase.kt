package com.hy0417sage.traveldiary.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hy0417sage.traveldiary.repository.data.DairyEntity

@Database(entities = [DairyEntity::class], version = 1, exportSchema = false)
abstract class DairyDataBase : RoomDatabase() {

    abstract fun getDiaryDao(): DairyDao

}