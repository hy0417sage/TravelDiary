package com.hy0417sage.traveldiary.ui.home.diary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hy0417sage.traveldiary.repository.data.DairyEntity
import com.hy0417sage.traveldiary.databinding.LayoutDiaryBinding

class DairyAdapter : ListAdapter<DairyEntity, RecyclerView.ViewHolder>(DairyDiffCallback()) {

    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DairyViewHolder(
            LayoutDiaryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DairyViewHolder) {
            val diary = getItem(position) as DairyEntity
            holder.bind(diary)
            holder.itemView.setOnClickListener {
                itemClickListener?.onClick(diary)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onClick(diary: DairyEntity)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}