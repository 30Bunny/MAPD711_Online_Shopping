package com.app.bansikajal_mapd711_project.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.bansikajal_mapd711_project.adapter.SizeAdapter
import com.app.bansikajal_mapd711_project.common.Common
import com.app.bansikajal_mapd711_project.common.appSharedPref
import com.app.bansikajal_mapd711_project.common.kHomeAndKitchen
import com.app.bansikajal_mapd711_project.common.kJewellery
import com.app.bansikajal_mapd711_project.common.selectedProduct
import com.app.bansikajal_mapd711_project.common.selectedQuantity
import com.app.bansikajal_mapd711_project.common.selectedSizeValue
import com.app.bansikajal_mapd711_project.common.showToast
import com.app.bansikajal_mapd711_project.databinding.ActivityProductDetailBinding
import com.app.bansikajal_mapd711_project.model.Product
import com.app.bansikajal_mapd711_project.model.Size
import com.google.gson.Gson

class ProductDetailActivity : AppCompatActivity(), SizeAdapter.SizeClickListener {
    private var selectedSize: String = ""
    private lateinit var sizeAdapter: SizeAdapter
    private lateinit var product: Product
    private lateinit var binding: ActivityProductDetailBinding
    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        product = intent.getSerializableExtra("Product") as Product
        binding.pimage.setImageResource(product.image)
        binding.company.text = product.company
        binding.tvHeading.text = product.company
        binding.name.text = product.name
        binding.price.text = product.price.toString()

        val sizeList = ArrayList<Size>()
        for (item in product.size) {
            sizeList.add(Size(size = item))
        }

        binding.rvSize.layoutManager =
            LinearLayoutManager(this@ProductDetailActivity, LinearLayoutManager.HORIZONTAL, false)
        sizeAdapter = SizeAdapter(this@ProductDetailActivity, sizeList, this)
        binding.rvSize.adapter = sizeAdapter

        if(product.category == kJewellery || product.category == kHomeAndKitchen){
            binding.rvSize.visibility = View.GONE
        }

        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.cirBagButton.setOnClickListener {
            if (validate()){
                // convert Product to json and stored it into shared pref
                val gson = Gson()
                val prefs = getSharedPreferences(appSharedPref, Context.MODE_PRIVATE)
                val productJson = gson.toJson(product)
                prefs.edit().putString(selectedProduct, productJson).apply()
                prefs.edit().putString(selectedSizeValue, selectedSize).apply()
                prefs.edit().putInt(selectedQuantity, quantity).apply()

                startActivity(Intent(this@ProductDetailActivity, ContactFormActivity::class.java))
            }
        }

        binding.minusImageView.setOnClickListener{
            if(quantity > 1){
                quantity--
            }
            binding.quantityTextView.text = quantity.toString()
        }

        binding.plusImageView.setOnClickListener{
            quantity++
            binding.quantityTextView.text = quantity.toString()
        }
    }

    override fun onItemClick(size: String) {
        selectedSize = size
    }

    private fun validate(): Boolean {
        if(product.category == kJewellery || product.category == kHomeAndKitchen){
            return true
        }else if (selectedSize.isNullOrBlank() || selectedSize.isNullOrEmpty()) {
            showToast(this, "Please select size")
            return false
        }
        return true
    }
}
