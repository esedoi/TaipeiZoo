package com.example.taipeizoo.animalDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.taipeizoo.databinding.FragmentAnimalBinding
import com.example.taipeizoo.databinding.FragmentExhibitsBinding
import com.example.taipeizoo.exhibitsDetail.ExhibitDetailFragmentArgs
import com.example.taipeizoo.model.Animal
import com.example.taipeizoo.model.Exhibit

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

        binding.tvDistribution.text = receivedData.distribution
        binding.tvFeature.text = receivedData.feature
        binding.tvHabit.text = receivedData.habitat

        Glide.with(this)
            .load(receivedData.pic01Url)
            .into(binding.ivAnimalDetail)
    }
}