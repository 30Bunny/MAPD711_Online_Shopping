package com.app.bansikajal_mapd711_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.bansikajal_mapd711_project.databinding.ItemProductBinding
import com.app.bansikajal_mapd711_project.model.Product

class ProductAdapter(
    var context: Context,
    var productList: ArrayList<Product>,
    private val productClickListener: ProductClickListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    
    private lateinit var binding: ItemProductBinding

    class ProductViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        binding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product = productList[position]
        binding.company.text = product.company
        binding.name.text = product.name
        binding.price.text = product.price.toString()
        binding.pimage.setImageResource(product.image)
        binding.itemView.setOnClickListener {
            productClickListener.onItemClick(product, position)
        }
    }

    interface ProductClickListener {
        fun onItemClick(product: Product, pos: Int)
    }

}
