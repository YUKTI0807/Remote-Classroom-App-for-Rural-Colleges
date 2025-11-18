package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.LightPurple
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.TextSecondary

@Composable
fun StudentClassesScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val subjects = listOf("All", "AI", "VLSI", "IoT", "Cloud", "Cyber Security", "Renewable Energy")
    var selectedSubject by remember { mutableStateOf("AI") } // Defaulting to AI as per image

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search Classes") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.small,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedContainerColor = Color(0xFFF5F5F5),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(subjects) { subject ->
                FilterChip(
                    selected = subject == selectedSubject,
                    onClick = { selectedSubject = subject },
                    label = { Text(subject) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = LightPurple,
                        selectedLabelColor = Color.Black
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(5) { // Dummy data
                ClassCardItem("CS101 - Intro to AI", "Dr. Smith", "12/12/2024", "45 mins")
            }
        }
    }
}

@Composable
fun ClassCardItem(title: String, teacher: String, date: String, duration: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = LightPurple),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "By $teacher on $date - $duration",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextSecondary
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(Icons.Default.Download, contentDescription = "Download")
                Text("15MB", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentClassesScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        StudentClassesScreen(rememberNavController())
    }
}
