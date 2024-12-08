package com.challenge.internshipchallenge.viewmodel

import androidx.lifecycle.ViewModel
import com.challenge.internshipchallenge.data.UserData
import com.google.firebase.firestore.FirebaseFirestore

class SignInViewModel: ViewModel() {
    fun signIn(
        id: String,
        pw: String,
        onSuccess: (UserData?) -> Unit,
        onFailure: (Exception?) -> Unit
    ) {
        val fireStore = FirebaseFirestore.getInstance()
        fireStore.collection("user")
            .whereEqualTo("id", id)
            .whereEqualTo("password", pw)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result.documents.size > 0) {
                        val data = task.result.documents.first().toObject(UserData::class.java)
                        onSuccess(data)
                    }
                } else {
                    onFailure(task.exception)
                }
            }
    }
}