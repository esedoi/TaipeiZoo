package com.example.taipeizoo.exhibits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeizoo.databinding.FragmentExhibitsBinding
import com.example.taipeizoo.exhibits_detail.ExhibitDetailFragmentDirections
import com.example.taipeizoo.model.Exhibit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExhibitsFragment : Fragment(), ExhibitSelected {

    private var _binding: FragmentExhibitsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExhibitsViewModel by viewModels()

    private lateinit var exhibitsAdapter: ExhibitsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExhibitsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupLiveData()
    }

    private fun setupLiveData() {
        viewModel.data.observe(viewLifecycleOwner) { data ->

            exhibitsAdapter.submitList(data)
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
        exhibitsAdapter = ExhibitsAdapter(this)
        binding.rvExhibits.layoutManager = LinearLayoutManager(this.context)
        binding.rvExhibits.adapter = exhibitsAdapter

        val dividerItemDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
        binding.rvExhibits.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun exhibitSelected(item: Exhibit) {
        findNavController().navigate(
            ExhibitDetailFragmentDirections.navigateToExhibitDetailFragment(
                item
            )
        )
    }
}