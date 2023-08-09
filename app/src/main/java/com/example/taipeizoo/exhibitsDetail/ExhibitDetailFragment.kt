package com.example.taipeizoo.exhibitsDetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeizoo.R
import com.example.taipeizoo.animalDetail.AnimalFragmentDirections
import com.example.taipeizoo.databinding.FragmentSecondBinding
import com.example.taipeizoo.exhibits.ExhibitsAdapter
import com.example.taipeizoo.exhibits.ExhibitsViewModel
import com.example.taipeizoo.model.Animal
import com.example.taipeizoo.model.Exhibit
import com.example.taipeizoo.model.ExhibitDetailItem
import com.google.android.material.dialog.InsetDialogOnTouchListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExhibitDetailFragment : Fragment(), AnimalSelected {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExhibitDetailViewModel by viewModels()

    private lateinit var exhibitDetailAdapter: ExhibitDetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupLiveData()

    }

    private fun setupLiveData() {
        viewModel.data.observe(viewLifecycleOwner) { data ->
            val args: ExhibitDetailFragmentArgs by navArgs()
            val receivedData: Exhibit = args.exhibit

            val combinedList: List<ExhibitDetailItem> =
                listOf(ExhibitDetailItem.ExhibitDetail(receivedData)) + data.map {
                    ExhibitDetailItem.AnimalItem(it)
                }

            exhibitDetailAdapter.submitList(combinedList)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->

            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    private fun setupRecyclerView() {
        exhibitDetailAdapter = ExhibitDetailAdapter(this)
        binding.rvExhibitDetail.layoutManager = LinearLayoutManager(this.context)
        binding.rvExhibitDetail.adapter = exhibitDetailAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun animalSelected(item: Animal) {
        Log.d("des___","des___, ExhibitDetailFragment, 79, item = $item")
        findNavController().navigate(AnimalFragmentDirections.navigateToAnimalDetailFragment(item))
    }
}