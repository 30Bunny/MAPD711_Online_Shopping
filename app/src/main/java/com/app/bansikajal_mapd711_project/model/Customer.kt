package com.app.bansikajal_mapd711_project.model

data class Customer(
    var id: String? = "",
    val fName: String? = "",
    val lName: String? = "",
    val email: String? = "",
    val password: String? = "",
)

fun mapToCustomer(map: Map<String, Any>): Customer {
    val fName = map["fname"] as String
    val lName = map["lname"] as String
    val email = map["email"] as String

    return Customer(fName = fName, lName = lName, email = email)
}