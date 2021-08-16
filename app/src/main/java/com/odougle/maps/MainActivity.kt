package com.odougle.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"
    private val ERROR_DIALOG_REQUEST: Int = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun isServicesOK(){
        Log.d(TAG,"isServicesOK: checking google services version")
        val available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this@MainActivity)
        if(available == ConnectionResult.SUCCESS){
            //ok
            Log.d(TAG, "isServicesOK: Google Play Services is working")
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error we can resolve it
            Log.d(TAG,"isServicesOK: an error occured but we can fix it")
            val dialog = GoogleApiAvailability.getInstance().getErrorDialog(this@MainActivity, available, ERROR_DIALOG_REQUEST)
            dialog.show()
        }else{
            Toast.makeText(this, "You can`t make map requests",Toast.LENGTH_SHORT).show()
        }
    }

}