package com.example.glowdayzapp.presentaion.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.ProductAllList
import com.example.domain.models.RecommendProduct
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.ProductListItemBinding
import com.example.glowdayzapp.databinding.RecommandListItemBinding
import java.text.DecimalFormat

class RecommandItemViewHolder(
    var binding: RecommandListItemBinding,
    private val recommendItemClickListener: (product: RecommendProduct) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    val dec = DecimalFormat("#,###")
    fun bind(productAllList: RecommendProduct) {
        productAllList.imageUrl?.let {
            Glide.with(binding.productImageRecommend.context)
                .load(it)
                .error(R.drawable.ic_launcher_background)
                .into(binding.productImageRecommend)
        }

        productAllList.let {
            binding.productTitleRecommend.text = it.productTitle
            binding.ratingAvgRecommend.text = it.ratingAvg.toString()
            binding.reviewCountRecommend.text = "(리뷰 " + dec.format(it.reviewCount.toInt()) + ")"
        }
        binding.fullLayoutRecommend.setOnClickListener{
            productAllList?.let { it -> recommendItemClickListener(it) }
        }

    }
}