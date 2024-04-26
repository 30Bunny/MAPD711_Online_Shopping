package com.app.bansikajal_mapd711_project.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.bansikajal_mapd711_project.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.cirBagButton.setOnClickListener {
            startActivity(Intent(this, ContactFormActivity::class.java))
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }
}
