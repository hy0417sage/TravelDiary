package com.hy0417sage.traveldiary.ui.home.diary

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hy0417sage.traveldiary.databinding.FragmentViewDiaryBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity

class ViewDairyFragment : Fragment() {

    private lateinit var dairyActivity: DairyActivity
    private lateinit var binding: FragmentViewDiaryBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DairyActivity) dairyActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewDiaryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.diaryTitle.text = dairyActivity.diaryTitle.toString()
        binding.diaryMainText.text = dairyActivity.diaryMainText.toString()

        binding.viewDiary.setOnClickListener {
            canEditDiary()
        }

        binding.deleteButton.setOnClickListener {
            canDeleteDiary()
        }
    }

    private fun canEditDiary() {
        dairyActivity.fragmentViewChange(EDIT_SIGNAL)
    }

    private fun canDeleteDiary() {
        dairyActivity.deleteDiary(
            DairyEntity(
                id = dairyActivity.diaryId,
                title = dairyActivity.diaryTitle,
                mainText = dairyActivity.diaryMainText
            )
        )
        dairyActivity.onBackPressedDispatcher.onBackPressed()
    }

    companion object {
        fun newInstance() = ViewDairyFragment()
        const val EDIT_SIGNAL: Int = -2
    }
}