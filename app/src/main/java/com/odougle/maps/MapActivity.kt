package com.odougle.maps

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.odougle.maps.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private val binding: ActivityMapBinding by lazy {
        ActivityMapBinding.inflate(layoutInflater)
    }

    private val TAG: String = "MapActivity"

    private val FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    private val COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION
    private val LOCATION_PERMISSION_REQUEST = 1234

    private var mLocationPermissionGranted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    private fun getLocationPermission(){
        val permissions = listOf<String>(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

        if(ContextCompat.checkSelfPermission(this.applicationContext,FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.applicationContext,COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionGranted = true
            }else{
                ActivityCompat.requestPermissions(this, permissions.toTypedArray(),LOCATION_PERMISSION_REQUEST)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        mLocationPermissionGranted = false
        when(requestCode){
            LOCATION_PERMISSION_REQUEST -> {
                if(grantResults.size > 0){
                    grantResults.forEach { grantResult ->
                        if(grantResult != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionGranted = false;
                            return
                        }
                    }
                    mLocationPermissionGranted = true;
                    //init our map
                }
            }
        }
    }
}
