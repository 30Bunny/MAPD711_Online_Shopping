package com.app.bansikajal_mapd711_project.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.isValidEmail
import com.app.bansikajal_mapd711_project.common.isValidMobile
import com.app.bansikajal_mapd711_project.common.selectedAddress
import com.app.bansikajal_mapd711_project.common.showToast
import com.app.bansikajal_mapd711_project.common.userName
import com.app.bansikajal_mapd711_project.databinding.ContactFormBinding
import com.app.bansikajal_mapd711_project.db.DatabaseManager
import com.app.bansikajal_mapd711_project.model.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ContactFormActivity : AppCompatActivity() {
    private lateinit var binding: ContactFormBinding
    private var customer: Customer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchData()
        setOnClickListener()

    }

    private fun fetchData(){
        val prefs = getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        val email = prefs.getString(userName,"")
        CoroutineScope(Dispatchers.IO).launch {
            customer = DatabaseManager.getInstance().getCustomerByEmail(email = email.toString())
            lifecycleScope.launch(Dispatchers.Main) {
               setData()
            }
        }
    }

    private fun setData(){
        binding.usernameEditText.setText(customer?.email.toString())
        binding.firstnameEditText.setText(customer?.fName.toString())
        binding.lastnameEditText.setText(customer?.lName.toString())
    }

    private fun setOnClickListener(){
        binding.continuepaymentButton.setOnClickListener {
            submit()
        }
    }

    private fun submit(){
        if (!validate())
            return

        //store address in shared pref
        val address = "${binding.addressEditText.text}, ${binding.postalcodeEditText.text}, ${binding.cityEditText.text}, ${binding.countryEditText.text}"
        val prefs = getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        prefs.edit().putString(selectedAddress, address).apply()

        startActivity(Intent(this, PaymentActivity::class.java))
    }

    // validating all inputs
    private fun validate(): Boolean {
        if (binding.firstnameEditText.text.isNullOrBlank() || binding.firstnameEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter first name")
            return false
        }else if (binding.lastnameEditText.text.isNullOrBlank() || binding.lastnameEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter last name")
            return false
        }else if (binding.usernameEditText.text.isNullOrBlank() || binding.usernameEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter email")
            return false
        }else if (!isValidEmail(binding.usernameEditText.text.toString())) {
            showToast(this ,"Please enter valid email")
            return false
        }else if (binding.addressEditText.text.isNullOrBlank() || binding.addressEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter address")
            return false
        } else if (binding.postalcodeEditText.text.isNullOrBlank() || binding.postalcodeEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter postal code")
            return false
        } else if (binding.postalcodeEditText.text!!.length != 6) {
            showToast(this ,"Please enter valid postal code")
            return false
        } else if (binding.cityEditText.text.isNullOrBlank() || binding.cityEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter city")
            return false
        } else if (binding.countryEditText.text.isNullOrBlank() || binding.countryEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter country")
            return false
        } else if (binding.phoneEditText.text.isNullOrBlank() || binding.phoneEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter phone number")
            return false
        }else if (!isValidMobile(binding.phoneEditText.text.toString())) {
            showToast(this ,"Please enter valid phone number")
            return false
        }
        return true
    }
}