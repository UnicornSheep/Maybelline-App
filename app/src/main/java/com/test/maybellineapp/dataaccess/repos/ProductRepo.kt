package com.test.maybellineapp.dataaccess.repos

import com.test.maybellineapp.dataaccess.models.Product
import com.test.maybellineapp.dataaccess.remote.RetrofitManager
import retrofit2.Callback

class ProductRepo {
    fun getAll(callBack : Callback<List<Product>>) {
     RetrofitManager.service.listProducts().enqueue(callBack)
    }
}