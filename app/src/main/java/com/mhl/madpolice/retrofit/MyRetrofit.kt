package com.mhl.madpolice.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun retrofit() : Retrofit = Retrofit.Builder()
        .baseUrl("http://mad2019.hakta.pro/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}