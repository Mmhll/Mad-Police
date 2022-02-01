package com.mhl.madpolice.apadters

data class department(val data : ArrayList<departmentData>, val success : Boolean)

data class departmentData(val id : String,
                      val address : String,
                      val boss : String,
                      val name : String,
                      val phone : String,
                      val email : String,
                      val description : String,
                      val coords : String)
