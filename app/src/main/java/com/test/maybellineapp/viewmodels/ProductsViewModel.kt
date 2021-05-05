package com.test.maybellineapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.maybellineapp.dataaccess.models.Product
import com.test.maybellineapp.dataaccess.repos.ProductRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel : ViewModel(){
    private val productRepo = ProductRepo()

    private val _products: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>().also{
            loadProducts()
        }
    }
    private val _selected = MutableLiveData<Product>()

    val products:LiveData<List<Product>> get() = _products
    val selected:LiveData<Product> get() = _selected

    private fun loadProducts() {
        productRepo.getAll(object : Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                _products.value = response.body()
            }

        })
    }


    fun select(product: Product) {
        _selected.value = product
    }
}