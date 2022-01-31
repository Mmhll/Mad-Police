package com.mhl.madpolice.retrofit

import com.mhl.madpolice.apadters.department
import com.mhl.madpolice.apadters.Login
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofitApi {
    @GET("department")
    fun getDepartment() : retrofit2.Call<department>
    @GET("login")
    fun getLogin(@Query("login") login : String, @Query("password") password : String):retrofit2.Call<Login>
}