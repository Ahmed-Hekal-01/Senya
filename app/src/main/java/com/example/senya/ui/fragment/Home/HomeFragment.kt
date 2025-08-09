package com.example.senya.ui.fragment.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.senya.databinding.FragmentHomeBinding
import com.example.senya.ui.fragment.BaseFragment

class HomeFragment : BaseFragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeAdapter = HomeFragmentAdapter {
            Toast.makeText(requireContext(), "Item clicked", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerview.adapter = homeAdapter
        binding.recyclerview.addItemDecoration(DividerItemDecoration(requireActivity() , RecyclerView.VERTICAL))
        homeAdapter.setData(attractions)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}