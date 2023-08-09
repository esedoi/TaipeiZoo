package com.example.taipeizoo.exhibits

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taipeizoo.databinding.ItemExhibitBinding
import com.example.taipeizoo.model.Exhibit


class ExhibitsAdapter(private val exhibitSelected: ExhibitSelected) :
    ListAdapter<Exhibit, RecyclerView.ViewHolder>(
        CourseCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ExhibitViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (holder is ExhibitViewHolder) {
            holder.bind(item, exhibitSelected)
        }
    }

    class ExhibitViewHolder(private var binding: ItemExhibitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Exhibit, exhibitSelected: ExhibitSelected) {

            setTitle(item)

            setInfoText(item)

            setMemoText(item)

            setCoverImg(item)

            itemView.setOnClickListener {
                exhibitSelected.exhibitSelected(item)
            }

        }

        private fun setMemoText(item: Exhibit) {
            binding.tvMemo.text = item.eMemo.ifEmpty { "無休館資訊" }
        }

        private fun setInfoText(item: Exhibit) {
            binding.tvInfo.text = item.eInfo
        }


        private fun setTitle(item: Exhibit) {
            binding.tvName.text = item.eName
        }

        private fun setCoverImg(item: Exhibit) {
            Glide.with(itemView)
                .load(item.ePicUrl)
                .override(binding.ivExhibit.width, binding.ivExhibit.height)
                .into(binding.ivExhibit)
        }


        companion object {
            fun from(parent: ViewGroup): ExhibitViewHolder {
                val view =
                    ItemExhibitBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ExhibitViewHolder(view)
            }
        }
    }
}

class CourseCallback : DiffUtil.ItemCallback<Exhibit>() {
    override fun areItemsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Exhibit, newItem: Exhibit): Boolean {
        return oldItem == newItem
    }
}

interface ExhibitSelected {
    fun exhibitSelected(item: Exhibit)
}