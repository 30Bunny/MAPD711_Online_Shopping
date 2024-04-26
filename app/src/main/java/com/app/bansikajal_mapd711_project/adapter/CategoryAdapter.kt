package com.app.bansikajal_mapd711_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.bansikajal_mapd711_project.databinding.ItemCategoryBinding
import com.app.bansikajal_mapd711_project.model.Category

class CategoryAdapter(
    var context: Context,
    var categoryList: ArrayList<Category>,
    private val categoryClickListener: CategoryClickListener
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    
    private lateinit var binding: ItemCategoryBinding

    class CategoryViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ItemCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoryViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var category = categoryList[position]
        binding.textView.text = category.c_name
        binding.imageview.setImageResource(category.image)
        binding.itemView.setOnClickListener {
            categoryClickListener.onItemClick(category, position)
        }
    }

    interface CategoryClickListener {
        fun onItemClick(category: Category, pos: Int)
    }

}
