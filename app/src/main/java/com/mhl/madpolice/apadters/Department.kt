package com.mhl.madpolice.apadters

data class Department(val data : ArrayList<DepartmentData>, val success : Boolean)

data class DepartmentData(val id : String,
                          val address : String,
                          val boss : String,
                          val name : String,
                          val phone : String,
                          val email : String,
                          val description : String,
                          val coords : String)
