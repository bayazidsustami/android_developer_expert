package com.dicoding.submission.thesports.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.dicoding.submission.thesports.commons.base.BaseActivity
import com.dicoding.submission.thesports.databinding.ActivityDetailMatchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMatchActivity : BaseActivity<ActivityDetailMatchBinding>(
    ActivityDetailMatchBinding::inflate
) {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(savedInstanceState: Bundle?) {

    }

}