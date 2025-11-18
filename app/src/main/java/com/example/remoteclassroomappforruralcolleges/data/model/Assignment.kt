package com.example.remoteclassroomappforruralcolleges.data.model

data class Assignment(
    val id: String,
    val title: String,
    val courseId: String,
    val dueDate: Long,
    val description: String
)
