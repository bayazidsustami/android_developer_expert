package com.dicoding.submission.thesports.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import com.dicoding.submission.thesports.commons.base.BaseFragment
import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(savedInstanceState: Bundle?) {
        viewModel.listEvent.observe(viewLifecycleOwner){result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("RESPONSE", "Loading")
                }
                is Resource.Success -> {
                    val data = result.data
                    Log.d("RESPONSE", data.toString())
                }
                is Resource.Error -> {
                    Log.d("RESPONSE", "Error : ${result.message}")
                }
            }
        }
    }
}