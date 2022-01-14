package com.surya.suryaproject

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Direction : AppCompatActivity() {
     lateinit var etsource:EditText
     lateinit var etdestination:EditText
     lateinit var button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direction)
        etsource= findViewById(R.id.et_Source)
        etdestination= findViewById(R.id.et_Destination)
        button=findViewById(R.id.track)
        button.setOnClickListener {  var ssource:String=etsource.text.toString().trim()
            var sdestination:String=etdestination.text.toString().trim()

            // check the location is entered
            if (ssource.equals("") && sdestination.equals("")){
                // both value are blank
                Toast.makeText(applicationContext,"Please enter the Location ",Toast.LENGTH_SHORT).show()
            }
            else{
                displyTracker(sdestination,ssource)
            } }

    }

//    override fun onClick(v: View?) {
//    var ssource:String=etsource.text.toString().trim()
//        var sdestination:String=etdestination.text.toString().trim()
//
//    // check the location is entered
//        if (ssource.equals("") && sdestination.equals("")){
//            // both value are blank
//            Toast.makeText(applicationContext,"Please enter the Location ",Toast.LENGTH_SHORT).show()
//        }
//        else{
//            displyTracker(sdestination,ssource)
//        }
//
//    }
    private fun displyTracker(sdestination: String, ssource: String) {
        // if the device  does not have a map install, then redirect it to play store
        try {
            // when map is install
            // initialize uri
            var uri:Uri= Uri.parse("https://www.google.co.in/maps/dir/$ssource/$sdestination")
            var intent= Intent(Intent.ACTION_VIEW,uri)
            // set package
            intent.setPackage("com.google.android.apps.maps")
            // set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // Start activity
            startActivity(intent)

        }catch (e:ActivityNotFoundException){
            // when google map is not installed
            var uri:Uri= Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
            // initialize intent with action view
            var intent=Intent(Intent.ACTION_VIEW,uri)
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // start activity
            startActivity(intent)

        }
    }
}