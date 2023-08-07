package com.example.taipeizoo.exhibits

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taipeizoo.databinding.ItemExhibitBinding
import com.example.taipeizoo.model.Exhibit


class ExhibitsAdapter :
    ListAdapter<Exhibit, RecyclerView.ViewHolder>(
        CourseCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ExhibitViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        if (holder is ExhibitViewHolder) {
            holder.bind(item)
        }
    }

    class ExhibitViewHolder(private var binding: ItemExhibitBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Exhibit) {

            setTitle(item)

            setInfoText(item)

            setMemoText(item)

            setCoverImg(item)

        }

        private fun setMemoText(item: Exhibit) {
            binding.tvMemo.text = item.eMemo
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
                .into(binding.ivExhibit)

        }


        companion object {
            fun from(parent: ViewGroup): ExhibitViewHolder {
                val order =
                    ItemExhibitBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ExhibitViewHolder(order)
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