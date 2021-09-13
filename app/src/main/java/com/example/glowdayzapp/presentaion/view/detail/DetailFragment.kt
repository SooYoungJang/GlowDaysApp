package com.example.glowdayzapp.presentaion.view.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding
    private lateinit var callback: OnBackPressedCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        initView()
    }



    fun initView() {

        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }

        if (args.recommendProduct == null && args.product != null) {
            Glide.with(requireActivity())
                .load(args.product?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(binding.productImage)

            binding.productTitle.text = args.product?.productTitle
        } else if (args.recommendProduct != null && args.product == null) {
            Glide.with(requireActivity())
                .load(args.recommendProduct?.imageUrl)
                .error(R.drawable.ic_launcher_background)
                .into(binding.productImage)

            binding.productTitle.text = args.recommendProduct?.productTitle
        }


    }

}