package com.example.glowdayzapp.presentaion.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.contains
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Product
import com.example.domain.models.ProductAllList
import com.example.domain.models.RecommendProduct
import com.example.glowdayzapp.databinding.ProductListItemBinding
import com.example.glowdayzapp.databinding.RecommandContainerBinding
import com.example.glowdayzapp.presentaion.view.viewholder.ProductViewHolder
import com.example.glowdayzapp.presentaion.view.viewholder.RecommandViewHolder

class ProductAdapter(
    private val productItemClickListener: (product: Product) -> Unit,
    private val recommendItemClickListener: (product: RecommendProduct) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val callback = object : DiffUtil.ItemCallback<ProductAllList>() {
        override fun areItemsTheSame(oldItem: ProductAllList, newItem: ProductAllList): Boolean {
            return oldItem.products == newItem.products
        }

        override fun areContentsTheSame(oldItem: ProductAllList, newItem: ProductAllList): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, callback)

    override fun getItemViewType(position: Int): Int {

        if (position == 10 || position == 21 || position == 32) {
            return TYPE_RECOMMEND
        }

        return TYPE_PRODUCT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_PRODUCT -> {
                val binding = ProductListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ProductViewHolder(binding,productItemClickListener)
            }
            else -> {
                val binding = RecommandContainerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RecommandViewHolder(binding,recommendItemClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val productItems = differ.currentList[position]
        if (holder is ProductViewHolder)
            holder.bind(productItems)
        else if (holder is RecommandViewHolder)
            holder.bind(productItems)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    companion object {
        const val TYPE_PRODUCT = 0
        const val TYPE_RECOMMEND = 1
    }

}