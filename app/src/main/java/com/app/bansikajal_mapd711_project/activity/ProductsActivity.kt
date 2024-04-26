package com.app.bansikajal_mapd711_project.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.app.bansikajal_mapd711_project.adapter.ProductAdapter
import com.app.bansikajal_mapd711_project.common.Common
import com.app.bansikajal_mapd711_project.databinding.ActivityProductsBinding
import com.app.bansikajal_mapd711_project.model.Product


class ProductsActivity : AppCompatActivity(), ProductAdapter.ProductClickListener {
    private var pos: Int = 0
    private var ptitle: String? = ""
    private lateinit var productAdapter: ProductAdapter
    private var productList: ArrayList<Product> = ArrayList()
    private lateinit var binding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setOnClickListener()
    }

    private fun initView() {
        ptitle = intent.getStringExtra("title")
        pos = intent.getIntExtra("pos", 0)
        binding.tvHeading.text = ptitle
        binding.rvProduct.layoutManager = GridLayoutManager(this@ProductsActivity, 2)
        productList = Common.getProductList(pos)
        productAdapter = ProductAdapter(this@ProductsActivity, productList, this)
        binding.rvProduct.adapter = productAdapter
    }

    private fun setOnClickListener(){
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onItemClick(product: Product, pos: Int) {
        startActivity(
            Intent(this@ProductsActivity, ProductDetailActivity::class.java)
                .putExtra("Product", product)
        )
    }

}
