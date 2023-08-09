package com.example.taipeizoo.animal_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.taipeizoo.MainActivity
import com.example.taipeizoo.databinding.FragmentAnimalBinding
import com.example.taipeizoo.data.Animal

class AnimalFragment : Fragment() {

    private var _binding: FragmentAnimalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: AnimalFragmentArgs by navArgs()
        val receivedData: Animal = args.animal

        seBarTitle(receivedData)

        binding.tvChName.text = receivedData.nameCh

        binding.tvEnName.text = receivedData.nameEn

        binding.tvAlsoKnown.text = receivedData.alsoKnown

        binding.tvDiet.text = receivedData.diet

        binding.tvDistribution.text = receivedData.distribution

        binding.tvFeature.text = receivedData.feature

        binding.tvBehavior.text = receivedData.behavior

        Glide.with(this)
            .load(receivedData.pic01Url)
            .into(binding.ivAnimalDetail)
    }

    private fun seBarTitle(receivedData: Animal) {

        receivedData.nameCh?.let { (activity as MainActivity).setBarTitle(it) }
    }
}