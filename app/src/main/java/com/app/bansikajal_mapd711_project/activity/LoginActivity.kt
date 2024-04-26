package com.app.bansikajal_mapd711_project.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.customerID
import com.app.bansikajal_mapd711_project.common.customerName
import com.app.bansikajal_mapd711_project.common.isLogin
import com.app.bansikajal_mapd711_project.common.showToast
import com.app.bansikajal_mapd711_project.common.userName
import com.app.bansikajal_mapd711_project.databinding.LoginBinding
import com.app.bansikajal_mapd711_project.db.AuthCallback
import com.app.bansikajal_mapd711_project.db.DatabaseManager
import com.app.bansikajal_mapd711_project.model.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        changeStatusBarColor()

        setContentView(binding.root)

        onClickListener()
    }

    private fun onClickListener() {
        binding.loginButton.setOnClickListener {
            login()
        }

        binding.signUpTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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

    private fun login(){
        if (!validate()){
            return
        }

        val email = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                DatabaseManager.getInstance().loginUser(email, password, object :
                    AuthCallback {
                    override fun onLoginSuccess(user: Customer) {
                        lifecycleScope.launch(Dispatchers.Main) {
                            // Handle successful login
                            println("Login successful. User: ${user.fName}")
                            showToast(this@LoginActivity, "Logged in successfully!")
                            saveUserData(user)
                        }
                    }

                    override fun onLoginFailure(errorMessage: String) {
                        lifecycleScope.launch(Dispatchers.Main) {
                            // Handle login failure
                            println("Login failed. Error: $errorMessage")
                            showToast(this@LoginActivity, "Account not found!")
                        }
                    }})
            }
    }

    // validating all inputs
    private fun validate(): Boolean {
        if (binding.usernameEditText.text.isNullOrBlank() || binding.usernameEditText.text.isNullOrEmpty()) {
            showToast(this, "Please enter username")
            return false
        }else if (binding.passwordEditText.text.isNullOrBlank() || binding.passwordEditText.text.isNullOrEmpty()) {
            showToast(this, "Please enter password")
            return false
        }
        return true
    }

    private fun saveUserData(user: Customer?) {
        val prefs = applicationContext.getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(isLogin, true).apply()
        prefs.edit().putString(userName, user?.email).apply()
        prefs.edit().putString(customerName, "${user?.fName} ${user?.lName}").apply()
        prefs.edit().putString(customerID, user?.id).apply()
        navigateToHome()
    }

    private fun navigateToHome(){
        startActivity(Intent(this, MainProductActivity::class.java))
        finish()
    }
}
