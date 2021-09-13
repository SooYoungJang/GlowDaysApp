package com.example.glowdayzapp.presentaion.view.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Product
import com.example.domain.models.RecommendProduct
import com.example.glowdayzapp.R
import com.example.glowdayzapp.databinding.FragmentMainBinding
import com.example.glowdayzapp.presentaion.view.adapter.ProductAdapter
import com.example.glowdayzapp.presentaion.viewmodel.main.MainFragmentViewModel


class ProductFragment : Fragment() {

    private lateinit var viewModel: MainFragmentViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var productAdapter: ProductAdapter


    private fun NavDirections.navigate(){
        NavHostFragment.findNavController(this@ProductFragment).navigate(this)
    }

    private val productItemClickListener: (Product) -> Unit = {
        ProductFragmentDirections.actionProductFragmentToDetailFragment(it, null).navigate()
    }

    private val recommendItemClickListener: (RecommendProduct) -> Unit = {
        ProductFragmentDirections.actionProductFragmentToDetailFragment(null, it).navigate()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.getProductList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        viewModel.ProductAllLiveData.observe(viewLifecycleOwner, Observer {
            productAdapter.differ.submitList(it)
        })
        initRecyclerView()
        viewMovieList()
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productItemClickListener,recommendItemClickListener)
        binding.recyclerView.adapter = productAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
    }


    private fun viewMovieList() {
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition = (recyclerView.layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
                val itemTotalCount = recyclerView.adapter!!.itemCount-1
                if (!binding.recyclerView.canScrollVertically(1) && lastVisibleItemPosition == itemTotalCount) {
                    viewModel.getAddProduct()

                }
            }
        })

    }



}



