package com.test.maybellineapp.dataaccess.models

data class Product (
    val id:Int,
    val name:String,
    val price:Double,
    val description:String,
    val image_link:String,
    val rating:Double
){
    val nameNormalised get() = name.removePrefix("Maybelline").trim()
}
