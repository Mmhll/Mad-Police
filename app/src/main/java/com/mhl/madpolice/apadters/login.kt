package com.mhl.madpolice.apadters

data class login(val data : ArrayList<loginData>, val success : Boolean)
data class loginData(val id : String, val login : String, val name : String, val token : String)
