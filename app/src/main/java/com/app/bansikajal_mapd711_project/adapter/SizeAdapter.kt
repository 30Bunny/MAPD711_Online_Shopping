package com.app.bansikajal_mapd711_project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.databinding.ItemSizeBinding
import com.app.bansikajal_mapd711_project.model.Size


class SizeAdapter(
    var context: Context,
    var sizeList: ArrayList<Size>,
    private val sizeClickListener: SizeClickListener
) : RecyclerView.Adapter<SizeAdapter.SizeViewHolder>() {
    
    private lateinit var binding: ItemSizeBinding

    class SizeViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sizeText: TextView = itemView.findViewById(R.id.tv_size)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SizeViewHolder {
        binding = ItemSizeBinding.inflate(LayoutInflater.from(context), parent, false)
        return SizeViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return sizeList.size
    }

    override fun onBindViewHolder(holder: SizeViewHolder, position: Int) {
        var size = sizeList[position]
        binding.tvSize.text = size.size
        if(size.isSelected){
            holder.sizeText.setBackgroundResource(R.drawable.bg_size_orange)
       }else{
            holder.sizeText.setBackgroundResource(R.drawable.bg_size)
        }

        binding.tvSize.setOnClickListener {
            for (item in sizeList) {
                item.isSelected = false
            }
            size.isSelected = true
            sizeClickListener.onItemClick(size.size!!)
            notifyDataSetChanged();

        }
    }

    interface SizeClickListener {
        fun onItemClick(size: String)
    }

}
