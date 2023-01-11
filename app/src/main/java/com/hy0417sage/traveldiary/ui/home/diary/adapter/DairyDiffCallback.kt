package com.hy0417sage.traveldiary.ui.home.diary.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hy0417sage.traveldiary.repository.data.DairyEntity

class DairyDiffCallback : DiffUtil.ItemCallback<DairyEntity>() {

    override fun areItemsTheSame(oldItem: DairyEntity, newItem: DairyEntity): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: DairyEntity, newItem: DairyEntity): Boolean {
        return oldItem == newItem
    }
}