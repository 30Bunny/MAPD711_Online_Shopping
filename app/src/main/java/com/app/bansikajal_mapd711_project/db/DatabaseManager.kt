package com.app.bansikajal_mapd711_project.db

import com.app.bansikajal_mapd711_project.model.Customer
import com.app.bansikajal_mapd711_project.model.Order
import com.app.bansikajal_mapd711_project.model.mapToCustomer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

interface DatabaseCallback {
    fun onSuccess(result: String)
    fun onError(error: String)
}

interface AuthCallback {
    fun onLoginSuccess(user: Customer)
    fun onLoginFailure(errorMessage: String)
}

class DatabaseManager {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()
    private val customersCollection = db.collection("customers")
    private val ordersCollection = db.collection("orders")

    companion object {
        private var instance: DatabaseManager? = null

        fun getInstance(): DatabaseManager {
            if (instance == null) {
                instance = DatabaseManager()
                // Additional initialization logic can be added here
            }
            return instance!!
        }
    }

    fun registerUser(customer: Customer, dbCallback: DatabaseCallback){

        // register user in Firebase Auth
        auth.createUserWithEmailAndPassword(customer.email.toString(), customer.password.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registration successful, store data in the Customer table
                    val newCustomer = Customer(fName = customer.fName, lName = customer.lName, email = customer.email)
                    customersCollection.add(newCustomer)
                        .addOnSuccessListener { documentReference ->
                            // Document added with ID: documentReference.id
                            dbCallback.onSuccess("Customer added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            // Handle errors
                            dbCallback.onError("Error adding customer: $e")
                        }
                } else {
                    // Registration failed, handle the error
                    dbCallback.onError("Error adding customer: something went wrong")
                }
            }
    }

    suspend fun loginUser(email: String, password: String, callback: AuthCallback): FirebaseUser? {
        return try {
            // Authenticate user
            val authResult = auth.signInWithEmailAndPassword(email, password).await()

            // Fetch customer data from Firestore based on authenticated user's email
            val user: FirebaseUser? = authResult.user
            if (user != null) {
                val customer = getCustomerByEmail(user.email!!)
                println("Customer data: $customer")
                if(customer != null){
                    callback.onLoginSuccess(customer)
                }else{
                    callback.onLoginFailure("Login failed")
                }
            }

            user
        } catch (e: Exception) {
            // Handle login failure
            println("Login failed. Error: ${e.message}")
            callback.onLoginFailure("Login failed. Error: ${e.message}")
            null
        }
    }

    suspend fun getCustomerByEmail(email: String): Customer? {
        return try {
            val querySnapshot = customersCollection
                .whereEqualTo("email", email)
                .limit(1)
                .get()
                .await()

            val document = querySnapshot.documents.firstOrNull()
            println("Document ID: ${document?.id}")
            var customer = document?.data?.let { mapToCustomer(it) }
            customer?.id = document?.id
            customer
        } catch (e: Exception) {
            // Handle Firestore query failure
            println("Error fetching customer data: ${e.message}")
            null
        }
    }

    fun createOrder(order: Order, dbCallback: DatabaseCallback){
        ordersCollection.add(order)
            .addOnSuccessListener { documentReference ->
                // Document added with ID: documentReference.id
                dbCallback.onSuccess("Order added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                // Handle errors
                dbCallback.onError("Error adding order: $e")
            }
    }

    fun signOut(){
        auth.signOut()
    }
}
