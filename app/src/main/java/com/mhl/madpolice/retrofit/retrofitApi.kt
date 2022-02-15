package com.mhl.madpolice.retrofit

import com.mhl.madpolice.apadters.Department
import com.mhl.madpolice.apadters.Login
import com.mhl.madpolice.apadters.Wanted
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface retrofitApi {
    @GET("department")
    fun getDepartment() : Call<Department>

    @GET("department/{page}")
    fun getCurrentDepartment(@Path(value = "page", encoded = true) page : String) : Call<Department>

    @GET("login")
    fun getLogin(@Query("login") login : String, @Query("password") password : String):Call<Login>
    @GET("wanted")
    fun getWanted() : Call<Wanted>

}