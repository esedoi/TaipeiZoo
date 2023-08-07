package com.example.taipeizoo.exhibits

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taipeizoo.databinding.FragmentExhibitsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExhibitsFragment : Fragment() {

    private var _binding: FragmentExhibitsBinding? = null

    private val viewModel: ExhibitsViewModel by viewModels()
    private val binding get() = _binding!!

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

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

        setupRecyclerView()

        viewModel.data.observe(viewLifecycleOwner) { data ->
            Log.d("des","des___ , ZooAreaFragment, 44, data =$data")

            exhibitsAdapter.submitList(data)
        }
    }

    private fun setupRecyclerView() {
        exhibitsAdapter = ExhibitsAdapter()
        binding.rvExhibits.layoutManager = LinearLayoutManager(this.context)
        binding.rvExhibits.adapter = exhibitsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}