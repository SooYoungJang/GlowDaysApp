package com.example.glowdayzapp.presentaion.viewmodel.main

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data_remote.repository.GlowDaysRepositoryImpl
import com.example.domain.models.ProductAllList
import com.example.domain.models.ProductList
import com.example.domain.models.RecommendProductList
import com.example.domain.repository.GlowDaysRepository
import com.example.domain.usecase.GetProductListUseCase
import com.example.domain.usecase.GetRecommendProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel  @Inject constructor (private val getProductListUseCase: GetProductListUseCase, private val getRecommendProductList: GetRecommendProductList)  : ViewModel(){

    private var pageNumber: Int = 1
    var state: Parcelable? = null

    private val productAllList = mutableListOf<ProductAllList>()
    private val _ProductAllLiveData = MutableLiveData<List<ProductAllList>>()
    val ProductAllLiveData: LiveData<List<ProductAllList>>
        get() = _ProductAllLiveData

    private lateinit var recommendproductsList : RecommendProductList


    fun getProductList() =viewModelScope.launch {
        val productResponse = async { getProductListUseCase.execute(pageNumber) }
        val recommendResponse = async { getRecommendProductList.execute() }
        computeResult(productResponse.await(), recommendResponse.await())
    }

    private suspend fun computeResult(productResponse: Flow<ProductList>, recommendResponse: Flow<RecommendProductList>) {

        if(pageNumber < 2) {
            recommendResponse.collect {
                recommendproductsList = it
            }
            productResponse.collect {
                it.productResponses.forEach {
                    productAllList.add(ProductAllList(it,null))
                }
            }
            productAllList.add(10, ProductAllList(null, recommendproductsList.recommendProduct1))
            productAllList.add(21, ProductAllList(null, recommendproductsList.recommendProduct2))
        }else if(pageNumber == 2) {
            recommendResponse.collect {
                recommendproductsList = it
            }
            productResponse.collect {
                it.productResponses.forEach {
                    productAllList.add(ProductAllList(it,null))
                }
            }
            productAllList.add(32, ProductAllList(null, recommendproductsList.recommendProduct3))
        } else {
            recommendResponse.collect {
                recommendproductsList = it
            }
            productResponse.collect {
                it.productResponses.forEach {
                    productAllList.add(ProductAllList(it,null))
                }
            }
        }
        _ProductAllLiveData.value = productAllList
    }

    fun getAddProduct() {
        pageNumber++
        if(pageNumber <= 3) {
            viewModelScope.launch {
                val productResponse = async { getProductListUseCase.execute(pageNumber) }
                val recommendResponse = async { getRecommendProductList.execute() }
                computeResult(productResponse.await(), recommendResponse.await())
            }
        }
    }
}