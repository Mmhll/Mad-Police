package com.mhl.madpolice.retrofit

import com.mhl.madpolice.apadters.department
import com.mhl.madpolice.apadters.Login
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface retrofitApi {
    @GET("department")
    fun getDepartment() : Call<department>

    @GET("department")
    fun getCurrentDepartment(@Path(value = "page", encoded = true) page : String) : Call<department>

    @GET("login")
    fun getLogin(@Query("login") login : String, @Query("password") password : String):Call<Login>

}