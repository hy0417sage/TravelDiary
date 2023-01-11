package com.hy0417sage.traveldiary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hy0417sage.traveldiary.repository.DairyRepository
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(private val dairyRepository: DairyRepository) :
    ViewModel() {

    fun wholeDiary() = dairyRepository.wholeDiary()

    fun insertDiary(dairyEntity: DairyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dairyRepository.insertDiary(dairyEntity)
        }
    }

    fun deleteDiary(dairyEntity: DairyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dairyRepository.deleteDiary(dairyEntity)
        }
    }

    fun updateDiary(dairyEntity: DairyEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            dairyRepository.updateDiary(dairyEntity)
        }
    }
}