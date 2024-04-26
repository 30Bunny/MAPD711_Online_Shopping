package com.app.bansikajal_mapd711_project.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.common.isValidEmail
import com.app.bansikajal_mapd711_project.common.isValidMobile
import com.app.bansikajal_mapd711_project.common.showToast
import com.app.bansikajal_mapd711_project.databinding.RegistrationBinding
import com.app.bansikajal_mapd711_project.db.DatabaseCallback
import com.app.bansikajal_mapd711_project.db.DatabaseManager
import com.app.bansikajal_mapd711_project.model.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor()

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.signUpButton.setOnClickListener {
            registerUser()
        }
        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //            window.setStatusBarColor(Color.TRANSPARENT);
            window.statusBarColor = resources.getColor(R.color.white)
        }
    }

    private fun registerUser(){
        if (!validate())
            return

        val fName = binding.firstnameEditText.text.toString()
        val lName = binding.lastnameEditText.text.toString()
        val email = binding.emailEditText.text.toString()
        val pwd = binding.passwordEditText.text.toString()

        val customer = Customer(fName = fName, lName = lName, email = email, password = pwd)
        DatabaseManager.getInstance().registerUser(customer, signUpCallback)

    }

    private val signUpCallback = object : DatabaseCallback {
        override fun onSuccess(result: String) {
            println("Success: $result")
            showToast(this@RegisterActivity,"Account register successfully!")
            finish()
        }

        override fun onError(error: String) {
            println("Error: $error")
            showToast(this@RegisterActivity, "Error: $error")
        }
    }

    // validating all inputs
    private fun validate(): Boolean {
        if (binding.firstnameEditText.text.isNullOrBlank() || binding.firstnameEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter first name")
            return false
        }else if (binding.lastnameEditText.text.isNullOrBlank() || binding.lastnameEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter last name")
            return false
        }else if (binding.emailEditText.text.isNullOrBlank() || binding.emailEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter email")
            return false
        }else if (!isValidEmail(binding.emailEditText.text.toString())) {
            showToast(this ,"Please enter valid email")
            return false
        }else if (binding.passwordEditText.text.isNullOrBlank() || binding.passwordEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter password")
            return false
        }else if(binding.passwordEditText.text.length < 6){
            showToast(this ,"Please must be 6 character long")
            return false
        }
        return true
    }

}
