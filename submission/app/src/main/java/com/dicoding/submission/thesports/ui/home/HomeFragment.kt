package com.dicoding.submission.thesports.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.submission.thesports.commons.base.BaseFragment
import com.dicoding.submission.thesports.commons.extensions.gone
import com.dicoding.submission.thesports.commons.extensions.visible
import com.dicoding.submission.thesports.core.data.commons.Resource
import com.dicoding.submission.thesports.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {
    private val viewModel: HomeViewModel by viewModels()
    private val adapter: EventAdapter by lazy { EventAdapter() }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        initAdapter()
        observeResult()
    }

    private fun observeResult(){
        viewModel.listEvent.observe(viewLifecycleOwner){result ->
            when(result){
                is Resource.Loading -> {
                    binding.pBar.visible()
                    binding.rvListEvent.gone()
                    binding.tvError.gone()
                }
                is Resource.Success -> {
                    val data = result.data
                    binding.pBar.gone()
                    binding.rvListEvent.visible()
                    binding.tvError.gone()
                    if (data != null){
                        adapter.submitList(data)
                    }
                }
                is Resource.Error -> {
                    binding.pBar.gone()
                    binding.rvListEvent.gone()
                    binding.tvError.run {
                        visible()
                        text = result.message
                    }
                }
            }
        }
    }

    private fun initAdapter(){
        with(binding.rvListEvent){
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
        }
    }
}