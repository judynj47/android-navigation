package com.example.augustmorningnavigationapp.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.augustmorningnavigationapp.models.Product
import com.example.augustmorningnavigationapp.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase

class ProductRepository(var navController:NavHostController, var context: Context) {
    var authRepository:AuthRepository
    var progress:ProgressDialog
    init {
        authRepository = AuthRepository(navController,context)
        if (!authRepository.isLoggedIn()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }
    fun saveProduct(productName:String,productQuantity:String,productPrice:String){
        var id = System.currentTimeMillis().toString()
        var productData = Product(productName,productQuantity,productPrice,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun viewProduct(){

    }
}