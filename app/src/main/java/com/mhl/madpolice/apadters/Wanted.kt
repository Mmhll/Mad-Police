package com.mhl.madpolice.apadters

data class Wanted(val data : ArrayList<WantedData>, val success : Boolean)

data class WantedData (val id : String,
                       val status : String,
                       val first_name : String,
                       val last_name : String,
                       val last_location : String,
                       val nicknames : String,
                       val description : String,
                       val photo : String)
