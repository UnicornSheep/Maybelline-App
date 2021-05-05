package com.test.maybellineapp.dataaccess.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitManager {
    private var retrofit = Retrofit.Builder()
        .baseUrl("https://makeup-api.herokuapp.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MaybellineService::class.java)

    val service
        get() = retrofit

}