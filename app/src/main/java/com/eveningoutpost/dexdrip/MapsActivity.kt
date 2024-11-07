package com.eveningoutpost.dexdrip

import android.app.Activity
import android.os.Bundle
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import com.eveningoutpost.dexdrip.models.JoH

class MapsActivity : FragmentActivity() {

    companion object {
        private const val defaultLocation = "-31.988644,115.515637" // default bogus position
        var lastGeoLocation: String = defaultLocation
        private val longs = mutableListOf<Double>()
        private val lats = mutableListOf<Double>()
        private var active = false
        private var staticActivity: Activity? = null

        // Receive updates from elsewhere (Placeholder)
        fun newMapLocation(location: String?, `when`: Long) {
            // Logic to handle new map location if needed in the future
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        staticActivity = this
        active = true

        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        )

        // Notify that the map feature is discontinued
        JoH.static_toast_long("Maps feature discontinued Sept 2022")
        finish()
    }

    override fun onPause() {
        active = false
        staticActivity = null
        super.onPause()
    }
}
