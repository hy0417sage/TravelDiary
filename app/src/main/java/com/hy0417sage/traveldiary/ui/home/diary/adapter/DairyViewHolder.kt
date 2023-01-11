package com.hy0417sage.traveldiary.ui.home.diary.adapter

import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.traveldiary.databinding.LayoutDiaryBinding
import com.hy0417sage.traveldiary.repository.data.DairyEntity

class DairyViewHolder(private val binding: LayoutDiaryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(diary: DairyEntity) {
        with(binding) {
            titleText.text = diary.mainText
            if (diary.title!!.isEmpty()) {
                titleText.text = diary.mainText
            } else {
                titleText.text = diary.title
            }
        }
    }
}