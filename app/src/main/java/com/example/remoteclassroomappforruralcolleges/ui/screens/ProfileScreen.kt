package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.SubjectBackground

@Composable
fun ProfileScreen(navController: NavController, role: String) {
    val name = if (role == "student") "Yukti" else "Jiya Ma'am"
    val email = if (role == "student") "yukti@example.com" else "jiya@example.com"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(64.dp)) // Top margin
        Text(name, style = MaterialTheme.typography.headlineMedium)
        Text(email, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        
        // Using OutlinedButton to simulate the rounded box look from the image
        OutlinedButton(
            onClick = { },
            modifier = Modifier.height(32.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 0.dp)
        ) {
            Text(role.capitalize(), style = MaterialTheme.typography.bodySmall)
        }
        
        Spacer(modifier = Modifier.height(32.dp))

        if (role == "student") {
            StudentStatsCard(75, 8, 24)
        } else {
            TeacherStatsCard(3, 5, 120)
        }
        Spacer(modifier = Modifier.height(32.dp))
        SettingsList()
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navController.navigate("welcome") {
                    popUpTo("welcome") { inclusive = true }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ExitToApp, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text("Logout")
        }
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun StudentStatsCard(attendance: Int, assignments: Int, classes: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SubjectBackground)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ProgressItem("$attendance%", "Attendance")
            ProgressItem("$assignments/10", "Submitted")
            ProgressItem("$classes/30", "Classes Attended")
        }
    }
}

@Composable
fun TeacherStatsCard(courses: Int, assignments: Int, students: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SubjectBackground)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ProgressItem("$courses", "Courses")
            ProgressItem("$assignments", "Assignments")
            ProgressItem("$students", "Students")
        }
    }
}

@Composable
fun ProgressItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, style = MaterialTheme.typography.titleMedium)
        Text(label, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun SettingsList() {
    Column {
        SettingsItem("Language")
        Divider()
        SettingsItem("Notifications")
        Divider()
        SettingsItem("Help Center")
        Divider()
        SettingsItem("About")
    }
}

@Composable
fun SettingsItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, style = MaterialTheme.typography.bodyLarge)
        Icon(Icons.Default.ChevronRight, contentDescription = null)
    }
}

private fun String.capitalize(): String {
    return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}

@Preview(showBackground = true, name = "Student Profile")
@Composable
fun StudentProfileScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        ProfileScreen(rememberNavController(), "student")
    }
}

@Preview(showBackground = true, name = "Teacher Profile")
@Composable
fun TeacherProfileScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        ProfileScreen(rememberNavController(), "teacher")
    }
}
