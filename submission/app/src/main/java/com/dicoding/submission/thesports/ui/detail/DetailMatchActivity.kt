package com.dicoding.submission.thesports.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.submission.thesports.R
import com.dicoding.submission.thesports.commons.base.BaseActivity
import com.dicoding.submission.thesports.core.domain.model.EventDomainModel
import com.dicoding.submission.thesports.databinding.ActivityDetailMatchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMatchActivity : BaseActivity<ActivityDetailMatchBinding>(
    ActivityDetailMatchBinding::inflate
) {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(savedInstanceState: Bundle?) {
        val detail = intent.getParcelableExtra<EventDomainModel>(DETAIL_EXTRA)
        if (detail != null){
            Glide.with(this)
                .load(detail.thumbnail)
                .into(binding.ivDetailImage)

            binding.tvMatch.text = detail.eventName
            binding.eventDate.text = detail.dataEvent
            binding.homeScore.text = detail.homeScore
            binding.awayScore.text = detail.awayScore
            binding.tvVenue.text = resources.getString(R.string.venue, detail.venue)
            binding.tvCountry.text = resources.getString(R.string.country, detail.country)

            var isFavorite = detail.isFavorite
            setStatusFavorite(isFavorite)

            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                viewModel.setFavorite(detail, isFavorite)
                setStatusFavorite(isFavorite)
            }
        }
    }

    private fun setStatusFavorite(state: Boolean){
        if (state){
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_filled))
        } else{
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        }
    }

    companion object{
        const val DETAIL_EXTRA = "extra_detail"
    }

}