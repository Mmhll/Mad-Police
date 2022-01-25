package com.mhl.madpolice.retrofit

import android.telecom.Call
import com.mhl.madpolice.apadters.department
import com.mhl.madpolice.apadters.login
import retrofit2.http.Body
import retrofit2.http.GET

interface retrofitApi {
    @GET("department/")
    fun getDepartment() : retrofit2.Call<department>
    @GET("login/")
    fun login(@Body hashMap: HashMap<String, String>):retrofit2.Call<login>
}