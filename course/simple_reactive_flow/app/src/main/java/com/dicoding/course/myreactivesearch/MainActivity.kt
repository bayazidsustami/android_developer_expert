package com.dicoding.course.myreactivesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edPlace = findViewById<AutoCompleteTextView>(R.id.ed_place)

        edPlace.doOnTextChanged { text, _, _, _ ->
            lifecycleScope.launchWhenCreated {
                viewModel.queryChannel.send(text.toString())
            }
        }

        viewModel.searchResult.observe(this){result ->
            val placesName = arrayListOf<String>()
            result.map {
                placesName.add(it.placeName)
            }
            val adapter = ArrayAdapter(this, android.R.layout.select_dialog_item, placesName)
            adapter.notifyDataSetChanged()
            edPlace.setAdapter(adapter)
        }
    }
}