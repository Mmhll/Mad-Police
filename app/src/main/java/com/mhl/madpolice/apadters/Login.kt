package com.mhl.madpolice.apadters

data class Login(val data : LoginData, val success : Boolean)
data class LoginData(val id : String, val login : String, val name : String, val token : String)
