package com.example.taipeizoo.exhibitsDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taipeizoo.databinding.ItemAnimalBinding
import com.example.taipeizoo.databinding.ItemExhibitDetailBinding
import com.example.taipeizoo.model.Animal
import com.example.taipeizoo.model.ExhibitDetailItem

class ExhibitDetailAdapter(private val animalSelected: AnimalSelected) :
    ListAdapter<ExhibitDetailItem, RecyclerView.ViewHolder>(
        CourseCallback()
    ) {

    companion object {
        private const val TYPE_EXHIBIT_DETAIL = 0
        private const val TYPE_ANIMAL = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ExhibitDetailItem.ExhibitDetail -> TYPE_EXHIBIT_DETAIL
            is ExhibitDetailItem.AnimalItem -> TYPE_ANIMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            TYPE_EXHIBIT_DETAIL -> ExhibitDetailViewHolder.from(parent)
            TYPE_ANIMAL -> AnimalViewHolder.from(parent)
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (val item = getItem(position)) {
            is ExhibitDetailItem.ExhibitDetail -> (holder as ExhibitDetailViewHolder).bind(item)
            is ExhibitDetailItem.AnimalItem -> (holder as AnimalViewHolder).bind(
                item,
                animalSelected
            )
        }
    }

    class ExhibitDetailViewHolder(private var binding: ItemExhibitDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExhibitDetailItem.ExhibitDetail) {

            setInfoText(item)

            setCoverImg(item)
        }

        private fun setInfoText(item: ExhibitDetailItem.ExhibitDetail) {
            binding.tvInfo.text = item.exhibit.eInfo
        }

        private fun setCoverImg(item: ExhibitDetailItem.ExhibitDetail) {
            Glide.with(itemView)
                .load(item.exhibit.ePicUrl)
                .into(binding.imageView)
        }


        companion object {
            fun from(parent: ViewGroup): ExhibitDetailViewHolder {
                val order =
                    ItemExhibitDetailBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ExhibitDetailViewHolder(order)
            }
        }
    }


    class AnimalViewHolder(private var binding: ItemAnimalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ExhibitDetailItem.AnimalItem, animalSelected: AnimalSelected) {

            setImg(item)
            setText(item)

            itemView.setOnClickListener {
                animalSelected.animalSelected(item.animal)
            }

        }

        private fun setText(item: ExhibitDetailItem.AnimalItem) {
            binding.tvName.text = item.animal.nameCh

        }

        private fun setImg(item: ExhibitDetailItem.AnimalItem) {
            Glide.with(itemView)
                .load(item.animal.pic01Url)
                .into(binding.ivAnimal)
        }


        companion object {
            fun from(parent: ViewGroup): AnimalViewHolder {
                val order =
                    ItemAnimalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return AnimalViewHolder(order)
            }
        }
    }
}

class CourseCallback : DiffUtil.ItemCallback<ExhibitDetailItem>() {
    override fun areItemsTheSame(oldItem: ExhibitDetailItem, newItem: ExhibitDetailItem): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: ExhibitDetailItem,
        newItem: ExhibitDetailItem
    ): Boolean {
        return oldItem == newItem
    }
}

interface AnimalSelected {
    fun animalSelected(item: Animal)
}