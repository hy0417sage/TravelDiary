package com.hy0417sage.traveldiary.ui.home.diary

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hy0417sage.traveldiary.databinding.FragmentEditDiaryBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity

class EditDiaryFragment : Fragment() {

    private lateinit var dairyActivity: DairyActivity
    private lateinit var binding: FragmentEditDiaryBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DairyActivity) dairyActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkDiaryExists(dairyActivity.diaryId)
    }

    private fun checkDiaryExists(id: Int) {
        when (id) {
            -1 -> insertDiary()
            else -> {
                binding.titleEdit.setText(dairyActivity.diaryTitle.toString())
                binding.mainTextEdit.setText(dairyActivity.diaryMainText.toString())
                insertDiary(id = dairyActivity.diaryId)
            }
        }
    }

    private fun insertDiary(id: Int? = null) {
        binding.insertDiary.setOnClickListener {
            val title = binding.titleEdit.text.toString()
            val mainText = binding.mainTextEdit.text.toString()
            if (title.isNotEmpty() || mainText.isNotEmpty()) {
                when (id) {
                    null -> {
                        dairyActivity.insertDiary(
                            diaryEntity(id, title, mainText)
                        )
                        dairyActivity.onBackPressedDispatcher.onBackPressed()
                    }
                    else -> {
                        dairyActivity.updateDairy(
                            diaryEntity(id, title, mainText)
                        )
                        dairyActivity.changeDiary(title, mainText)
                        dairyActivity.fragmentViewChange(id)
                    }
                }
            } else {
                Toast.makeText(
                    dairyActivity,
                    "diary is empty\n can't save (｡•́︿•̀｡)",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun diaryEntity(id: Int?, title: String, mainText: String): DairyEntity {
        return DairyEntity(
            id,
            title,
            mainText
        )
    }

    companion object {
        fun newInstance() = EditDiaryFragment()
    }
}