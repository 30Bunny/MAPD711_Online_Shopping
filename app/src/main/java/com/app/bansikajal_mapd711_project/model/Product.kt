package com.app.bansikajal_mapd711_project.model

import java.io.Serializable

data class Product(
    val image: Int,
    val name: String,
    val company: String,
    val price: Int,
    val size: ArrayList<String>,
    val category: String = ""
) : Serializable
