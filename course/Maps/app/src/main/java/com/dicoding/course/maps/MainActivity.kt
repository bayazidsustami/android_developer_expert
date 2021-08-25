package com.dicoding.course.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style

class MainActivity : AppCompatActivity() {

    private val mapview: MapView by lazy { findViewById(R.id.mapView) }
    private val btnNavigation: Button by lazy { findViewById(R.id.btnNavigation) }

    private lateinit var mapBox: MapboxMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapview.onCreate(savedInstanceState)
        mapview.getMapAsync { mapBoxMap ->
            this.mapBox = mapBoxMap
            mapBox.setStyle(Style.MAPBOX_STREETS){style ->

            }
        }
    }

    override fun onStart() {
        super.onStart()
        mapview.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapview.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapview.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapview.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        mapview.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapview.onLowMemory()
    }
}