package com.hy0417sage.traveldiary.module

import android.content.Context
import androidx.room.Room
import com.hy0417sage.traveldiary.repository.DairyRepository
import com.hy0417sage.traveldiary.repository.database.DairyDao
import com.hy0417sage.traveldiary.repository.database.DairyDataBase
import com.hy0417sage.traveldiary.repository.impl.DairyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DIModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): DairyDataBase {
        return Room.databaseBuilder(
            context.applicationContext,
            DairyDataBase::class.java,
            "DearDairy.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideDiaryDao(appDataBase: DairyDataBase): DairyDao {
        return appDataBase.getDiaryDao()
    }

    @Singleton
    @Provides
    fun provideRepository(
        noteDAO: DairyDao
    ): DairyRepository {
        return DairyRepositoryImpl(noteDAO)
    }
}
