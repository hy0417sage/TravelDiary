package com.hy0417sage.traveldiary.ui.home.diary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hy0417sage.traveldiary.R
import com.hy0417sage.traveldiary.databinding.ActivityDiaryBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import com.hy0417sage.traveldiary.viewmodel.DiaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DairyActivity : AppCompatActivity() {

    var diaryTitle: String? = null
    var diaryMainText: String? = null
    var diaryId: Int = -1

    private val diaryViewModel: DiaryViewModel by viewModels()
    private lateinit var binding: ActivityDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        diaryId = intent.getIntExtra("id", -1)
        diaryTitle = intent.getStringExtra("title")
        diaryMainText = intent.getStringExtra("mainText")
        fragmentViewChange(signal = diaryId)
    }

    fun changeDiary(dairyTitle: String, diaryMainText: String) {
        this.diaryTitle = dairyTitle
        this.diaryMainText = diaryMainText
    }

    fun fragmentViewChange(signal: Int) {
        when (signal) {
            CREATE_SIGNAL, EDIT_SIGNAL -> supportFragmentManager.beginTransaction()
                .replace(R.id.container, EditDiaryFragment.newInstance())
                .commit()
            else -> supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewDairyFragment.newInstance())
                .commit()
        }
    }

    fun insertDiary(dairyEntity: DairyEntity) {
        diaryViewModel.insertDiary(dairyEntity)
    }

    fun deleteDiary(dairyEntity: DairyEntity) {
        diaryViewModel.deleteDiary(dairyEntity)
    }

    fun updateDairy(dairyEntity: DairyEntity) {
        diaryViewModel.updateDiary(dairyEntity)
    }

    companion object {
        const val CREATE_SIGNAL: Int = -1
        const val EDIT_SIGNAL: Int = -2
        fun newIntent(context: Context, id: Int?, title: String?, mainText: String?): Intent =
            Intent(context, DairyActivity::class.java).apply {
                putExtra("id", id)
                putExtra("title", title)
                putExtra("mainText", mainText)
            }
    }
}