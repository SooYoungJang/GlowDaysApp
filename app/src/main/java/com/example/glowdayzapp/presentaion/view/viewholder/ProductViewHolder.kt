package com.example.glowdayzapp.presentaion.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Product
import com.example.domain.models.ProductAllList
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.ProductListItemBinding
import java.text.DecimalFormat

class ProductViewHolder(
    var binding: ProductListItemBinding,
    private val productItemClickListener: (product: Product) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    val dec = DecimalFormat("#,###")
    fun bind(productAllList: ProductAllList) {

        productAllList.products?.imageUrl?.let {
            Glide.with(binding.productImage.context)
                .load(it)
                .error(R.drawable.ic_launcher_background)
                .into(binding.productImage)
        }
        productAllList.products?.let {
            binding.productNumber.text = it.productRank
            binding.brandTitle.text = it.brandResponse.brandTitle
            binding.productTitle.text = it.productTitle
            binding.ratingAvg.text = it.ratingAvg.toString()
            binding.reviewCount.text = "(리뷰 " + dec.format(it.reviewCount.toInt()) + ")"
        }
        binding.fullLayout.setOnClickListener{
            productAllList.products?.let { it -> productItemClickListener(it) }
        }
    }
}