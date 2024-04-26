package com.app.bansikajal_mapd711_project.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.databinding.ActivityPaymentBinding
import com.app.bansikajal_mapd711_project.databinding.ActivityThankyouBinding

class ThankYouActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThankyouBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThankyouBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        binding.continueButton.setOnClickListener { navigateToHome() }
    }

    private fun navigateToHome(){
        val intent = Intent(this, MainProductActivity::class.java)
        startActivity(intent)
        finish()
    }


    // Override the onBackPressed method to disable the back button
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
    }
}
