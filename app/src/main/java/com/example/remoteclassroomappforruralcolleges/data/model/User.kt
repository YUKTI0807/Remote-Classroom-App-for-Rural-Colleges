package com.example.remoteclassroomappforruralcolleges.data.model

data class User(
    val uid: String,
    val name: String,
    val email: String,
    val phone: String,
    val role: String, // "student" or "teacher"
    val branch: String? = null
)
