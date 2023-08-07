package com.example.taipeizoo.zoo_area

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taipeizoo.R
import com.example.taipeizoo.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ZooAreaFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

//    private val viewModel: ZooAreaViewModel by viewModels()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }

       val viewModel: ZooAreaViewModel by viewModels()

        viewModel.data.observe(viewLifecycleOwner) { data ->
            Log.d("des","des___ , ZooAreaFragment, 44, data =$data")
            // 更新 UI
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}