package com.challenge.internshipchallenge.viewmodel

import androidx.lifecycle.ViewModel
import com.challenge.internshipchallenge.data.UserData
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpViewModel: ViewModel() {
    private val _idState = MutableStateFlow("")
    private val _nameState = MutableStateFlow("")
    private val _pwState = MutableStateFlow("")

    fun saveUserData(
        id: String,
        name: String,
        pw: String
    ) {
        _idState.value = id
        _nameState.value = name
        _pwState.value = pw
    }

    fun signUp(
        onSuccess: () -> Unit,
        onFailure: (Exception?) -> Unit,
    ) {
        val fireStore = FirebaseFirestore.getInstance()

        fireStore.collection("user").document(_idState.value).set(
            UserData(
                id = _idState.value,
                name = _nameState.value,
                password = _pwState.value
            )
        ).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                onFailure(task.exception)
            }
        }

    }
}