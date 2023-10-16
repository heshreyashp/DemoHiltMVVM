package com.cheezycode.daggermvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cheezycode.daggermvvm.models.Product
import com.cheezycode.daggermvvm.retrofit.NewFakerAPI
import java.com.cheezycode.daggermvvm.db.FakerDB
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val fakerAPI: NewFakerAPI
) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

/*    suspend fun getProducts() {
        val result = fakerAPI.getProducts()
        if (result.isSuccessful && result.body() != null) {
            fakerDB.getFakerDAO().addProducts(result.body()!!)
            _products.postValue(result.body())
        } else Log.d("ProductRepo", "getProducts: null")
    }*/

    suspend fun getNewAPI() {
        val result = fakerAPI.validate("123456789")
        if (result.isSuccessful && result.body() != null) {
            Log.d("ProductRepo", "getNewAPI: ${result.body()}")
        } else Log.d("ProductRepo", "getProducts: null")
    }

}