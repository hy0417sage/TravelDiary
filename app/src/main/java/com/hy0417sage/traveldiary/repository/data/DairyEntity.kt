package com.hy0417sage.traveldiary.repository.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DairyEntity")
data class DairyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "mainText") val mainText: String? = null
)
