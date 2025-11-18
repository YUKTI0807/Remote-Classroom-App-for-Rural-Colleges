package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme

@Composable
fun TeacherClassesScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Add new class */ }) {
                Icon(Icons.Default.Add, contentDescription = "Add Class")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(5) { // Dummy data
                TeacherClassCardItem("CS101 - Intro to AI", 45)
            }
        }
    }
}

@Composable
fun TeacherClassCardItem(title: String, studentCount: Int) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text("$studentCount students joined", style = MaterialTheme.typography.bodySmall)
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Manage")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeacherClassesScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        TeacherClassesScreen(rememberNavController())
    }
}
