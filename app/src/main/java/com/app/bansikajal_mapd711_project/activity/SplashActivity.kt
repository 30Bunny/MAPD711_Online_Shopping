package com.app.bansikajal_mapd711_project.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.app.bansikajal_mapd711_project.MainActivity
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.isLogin

class SplashActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 3000 // 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

//        Handler(Looper.getMainLooper()).postAtTime(
//            {
//                checkLoginUser()
//            },
//            System.currentTimeMillis() + splashTimeOut
//        )

        Handler().postDelayed({
            checkLoginUser()
        }, splashTimeOut)
    }

    private fun navigateToLogin(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun checkLoginUser(){
        val prefs = applicationContext.getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        val isLoggedIn: Boolean = prefs.getBoolean(isLogin, false)

        if(isLoggedIn){
            navigateToHome()
        }else{
            navigateToLogin()
        }
    }

    private fun navigateToHome(){
        val intent = Intent(this, MainProductActivity::class.java)
        startActivity(intent)
        finish()
    }
}