package com.odougle.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.maps.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private val binding: ActivityMapBinding by lazy {
        ActivityMapBinding.inflate(layoutInflater)
    }

    private val TAG: String = "MapActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
