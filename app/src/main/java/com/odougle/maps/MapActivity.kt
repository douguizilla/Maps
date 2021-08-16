package com.odougle.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.maps.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private val binding: ActivityMapBinding = ActivityMapBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}