package com.dicoding.course.maps

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.plugins.annotation.SymbolManager
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions

class MainActivity : AppCompatActivity() {

    companion object{
        private const val ICON_ID = "ICON_ID"
    }

    private val mapview: MapView by lazy { findViewById(R.id.mapView) }
    private val btnNavigation: Button by lazy { findViewById(R.id.btnNavigation) }

    private lateinit var mapBox: MapboxMap
    private lateinit var symbolManager: SymbolManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapview.onCreate(savedInstanceState)
        mapview.getMapAsync { mapBoxMap ->
            this.mapBox = mapBoxMap
            mapBox.setStyle(Style.MAPBOX_STREETS){style ->
                symbolManager = SymbolManager(mapview, mapBox, style)
                symbolManager.iconAllowOverlap = true

                style.addImage(
                    ICON_ID,
                    BitmapFactory.decodeResource(resources, R.drawable.mapbox_marker_icon_default)
                )

                showDicodingSpace()
            }
        }
    }

    private fun showDicodingSpace(){
        val dicodingSpace =  LatLng(-6.8957643, 107.6338462)
        symbolManager.create(
            SymbolOptions()
                .withLatLng(LatLng(dicodingSpace.latitude, dicodingSpace.longitude))
                .withIconImage(ICON_ID)
                .withIconSize(1.5f)
                .withIconOffset(arrayOf(0f, -1.5f))
                .withTextField("Dicoding Space")
                .withTextHaloColor("rgba(255, 255, 255, 100)")
                .withTextHaloWidth(5.0f)
                .withTextAnchor("top")
                .withTextOffset(arrayOf(0f, -1.5f))
                .withDraggable(true)
        )

        mapBox.moveCamera(CameraUpdateFactory.newLatLngZoom(dicodingSpace, 8.0))
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