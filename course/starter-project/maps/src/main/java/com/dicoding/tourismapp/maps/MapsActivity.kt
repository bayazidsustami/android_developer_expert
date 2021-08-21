package com.dicoding.tourismapp.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.maps.databinding.ActivityMapsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class MapsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMapsBinding

    private val viewModel: MapsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(mapsModule)

        supportActionBar?.title = "Tourism App"
        getTourismData()
    }

    private fun getTourismData() {
        viewModel.tourism.observe(this){tourism ->
            if (tourism != null){
                when(tourism){
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success ->{
                        binding.progressBar.visibility = View.GONE
                        binding.tvMaps.text = "This is map of ${tourism.data?.get(0)?.name}"
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                        binding.tvError.text = tourism.message
                    }
                }
            }
        }
    }
}