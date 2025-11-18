package com.example.remoteclassroomappforruralcolleges.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remoteclassroomappforruralcolleges.data.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun login(email: String, pass: String, role: String) {
        viewModelScope.launch {
            // TODO: Implement actual login logic with a repository
            if (email.isNotEmpty() && pass.isNotEmpty()) {
                _user.value = User(
                    uid = "12345",
                    name = "Aman Kumar",
                    email = email,
                    phone = "1234567890",
                    role = role,
                    branch = "Computer Science"
                )
            } else {
                _error.value = "Invalid credentials"
            }
        }
    }
}
