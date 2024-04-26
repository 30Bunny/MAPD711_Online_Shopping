package com.app.bansikajal_mapd711_project.activity

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.customerName
import com.app.bansikajal_mapd711_project.common.getCurrentDate
import com.app.bansikajal_mapd711_project.common.selectedAddress
import com.app.bansikajal_mapd711_project.common.selectedProduct
import com.app.bansikajal_mapd711_project.common.selectedQuantity
import com.app.bansikajal_mapd711_project.common.selectedSizeValue
import com.app.bansikajal_mapd711_project.common.showToast
import com.app.bansikajal_mapd711_project.common.userName
import com.app.bansikajal_mapd711_project.databinding.ActivityPaymentBinding
import com.app.bansikajal_mapd711_project.db.DatabaseCallback
import com.app.bansikajal_mapd711_project.db.DatabaseManager
import com.app.bansikajal_mapd711_project.model.Order
import com.app.bansikajal_mapd711_project.model.Product
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class PaymentActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityPaymentBinding
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.PaymentButton.setOnClickListener {
            placeOrder()
        }
        // Set OnClickListener on the EditText to show DatePickerDialog
        binding.exdateEditText.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            R.style.DatePickerTheme, this, year, month, day)
        // Set the minimum date to the current date
        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
        datePickerDialog.show()
        datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(getColor(R.color.colorPrimary));
        datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(getColor(R.color.colorPrimary));
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        // Handle the selected date
        val selectedDate = Calendar.getInstance().apply {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
        }

        val sdf = SimpleDateFormat("MM/yy", Locale.US)
        val formattedDate = sdf.format(selectedDate.time)

        // Update the EditText with the selected date
        binding.exdateEditText.setText(formattedDate)
    }

    // validating all inputs
    private fun validate(): Boolean {
        if (binding.cardNumberEditText.text.isNullOrBlank() || binding.cardNumberEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter card number")
            return false
        } else if (binding.cardNumberEditText.text?.length != 16) {
            showToast(this ,"Please enter valid card number")
            return false
        } else if (binding.exdateEditText.text.isNullOrBlank() || binding.exdateEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please select expiry date")
            return false
        } else if (binding.cvvEditText.text.isNullOrBlank() || binding.cvvEditText.text.isNullOrEmpty()) {
            showToast(this ,"Please enter CVV")
            return false
        } else if (binding.cvvEditText.text?.length != 3) {
            showToast(this ,"Please enter valid CVV")
            return false
        }
        return true
    }

    private fun placeOrder(){
        if (!validate())
            return

        //fetch data from shared preference
        val prefs = getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
        val email = prefs.getString(userName, "")
        val name = prefs.getString(customerName, "")
        val address = prefs.getString(selectedAddress, "")
        var product : Product? = null
        val productJson = prefs.getString(selectedProduct, null)
        if (productJson != null) {
            product = gson.fromJson(productJson, Product::class.java)
        }
        val size = prefs.getString(selectedSizeValue, "")
        val quantity = prefs.getInt(selectedQuantity, 1)

        val order = Order(customerEmail = email, customerName = name, customerAddress = address,
            productName = product?.name.toString(), productPrice = product?.price.toString(),
            size = size!!, quantity = quantity, orderDate = getCurrentDate()
        )
        DatabaseManager.getInstance().createOrder(order, placeOrderCallback)

    }

    private val placeOrderCallback = object : DatabaseCallback {
        override fun onSuccess(result: String) {
            println("Success: $result")
            val intent = Intent(this@PaymentActivity, ThankYouActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        override fun onError(error: String) {
            println("Error: $error")
            showToast(this@PaymentActivity, "Error: $error")
        }
    }
}