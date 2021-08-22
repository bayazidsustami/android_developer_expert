package com.dicoding.submission.thesports.favorite

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.submission.thesports.commons.base.BaseFragment
import com.dicoding.submission.thesports.di.FavoriteModuleDependencies
import com.dicoding.submission.thesports.favorite.component.DaggerFavoriteComponent
import com.dicoding.submission.thesports.favorite.databinding.FragmentFavoriteBinding
import com.dicoding.submission.thesports.favorite.viewModel.FavoriteViewModel
import com.dicoding.submission.thesports.favorite.viewModel.FavoriteViewModelFactory
import com.dicoding.submission.thesports.ui.home.EventAdapter
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment: BaseFragment<FragmentFavoriteBinding>(
    FragmentFavoriteBinding::inflate
) {
    @Inject lateinit var factory: FavoriteViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels { factory }
    private val adapter: EventAdapter by lazy { EventAdapter() }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            ).build().inject(this)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        initAdapter()
        viewModel.listFavoriteUseCase.observe(viewLifecycleOwner){result ->
            adapter.submitList(result)
        }
    }

    private fun initAdapter(){
        with(binding.rvListEvent){
            adapter = this@FavoriteFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
        }
    }
}