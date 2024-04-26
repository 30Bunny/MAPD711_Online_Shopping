package com.app.bansikajal_mapd711_project.model

data class Order(
    var id: String? = "",
    var customerEmail: String? = "",
    var customerName: String? = "",
    var customerAddress: String? = "",
    val orderDate: String = "",
    val productName: String = "",
    val productPrice: String = "",
    val quantity: Int = 1,
    val status: String = "In-Progress",
    val size: String = "",
)