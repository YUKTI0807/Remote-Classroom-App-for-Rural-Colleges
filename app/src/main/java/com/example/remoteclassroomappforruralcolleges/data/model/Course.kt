package com.example.remoteclassroomappforruralcolleges.data.model

data class Course(
    val id: String,
    val name: String,
    val teacher: String,
    val students: List<String> // List of student UIDs
)
