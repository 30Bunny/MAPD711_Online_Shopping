package com.app.bansikajal_mapd711_project.common

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val currentDate = Date()
    val formatter = SimpleDateFormat("dd-MM-yyyy") // Customize the format if needed
    return formatter.format(currentDate)
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return email.matches(emailRegex)
}

fun isValidMobile(mobile: String): Boolean {
    // Simple mobile number validation, you might want to customize it based on your needs
    val mobileRegex = Regex("^[0-9]{10}\$")
    return mobile.matches(mobileRegex)
}

fun showToast(context: Context,message: String){
    Toast.makeText(
        context,
        message,
        Toast.LENGTH_LONG
    ).show()
}