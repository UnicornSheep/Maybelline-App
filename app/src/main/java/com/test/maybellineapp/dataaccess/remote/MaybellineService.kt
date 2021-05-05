package com.test.maybellineapp.dataaccess.remote

import com.test.maybellineapp.dataaccess.models.Product
import retrofit2.Call
import retrofit2.http.GET


interface MaybellineService {
    @GET("products.json?brand=maybelline")
    fun listProducts(): Call<List<Product>>
}