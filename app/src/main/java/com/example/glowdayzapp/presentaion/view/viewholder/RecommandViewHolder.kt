package com.example.glowdayzapp.presentaion.view.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.ProductAllList
import com.example.domain.models.RecommendProduct
import com.example.glowdayzapp.databinding.RecommandContainerBinding
import com.example.glowdayzapp.presentaion.view.adapter.RecommendAdapter

class RecommandViewHolder (var binding: RecommandContainerBinding ,private val recommendItemClickListener: (recommendProduct: RecommendProduct) -> Unit
) : RecyclerView.ViewHolder(binding.root){
    private lateinit var recommendAdapter: RecommendAdapter
    fun bind(recommendProduct: ProductAllList) {
        recommendAdapter = RecommendAdapter(recommendItemClickListener)

        recommendProduct.recommend?.let {
            recommendAdapter.differ.submitList(it)
        }

        recommendProduct?.let{
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(context).also { it.orientation = LinearLayoutManager.HORIZONTAL }
                adapter = recommendAdapter
            }
        }
    }
}