package com.example.remoteclassroomappforruralcolleges.data.model

data class Submission(
    val id: String,
    val assignmentId: String,
    val studentId: String,
    val submissionDate: Long,
    val fileUrl: String, // Link to the submitted file
    val grade: String? = null
)
