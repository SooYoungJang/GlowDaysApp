package com.example.glowdayzapp.presentaion.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ProductAllList
import com.example.domain.models.RecommendProduct
import com.example.glowdayzapp.databinding.RecommandListItemBinding
import com.example.glowdayzapp.presentaion.view.viewholder.ProductViewHolder
import com.example.glowdayzapp.presentaion.view.viewholder.RecommandItemViewHolder

class RecommendAdapter(private val recommendItemClickListener: (product: RecommendProduct) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val callback = object : DiffUtil.ItemCallback<RecommendProduct>(){
        override fun areItemsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
            return oldItem.productTitle == newItem.productTitle
        }

        override fun areContentsTheSame(oldItem: RecommendProduct, newItem: RecommendProduct): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = RecommandListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommandItemViewHolder(binding,recommendItemClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recommendItem = differ.currentList[position]
        if (holder is RecommandItemViewHolder)
            holder.bind(recommendItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}