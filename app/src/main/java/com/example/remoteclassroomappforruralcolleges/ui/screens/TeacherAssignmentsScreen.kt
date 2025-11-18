package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun TeacherAssignmentsScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: Create new assignment */ }) {
                Icon(Icons.Default.Add, contentDescription = "Create Assignment")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(5) { // Dummy data
                TeacherAssignmentCardItem("Assignment on Quantum Mechanics", "Quantum Mechanics", 30)
            }
        }
    }
}

@Composable
fun TeacherAssignmentCardItem(title: String, subject: String, submissions: Int) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Text("Subject: $subject", style = MaterialTheme.typography.bodySmall)
                Text("$submissions submissions", style = MaterialTheme.typography.bodySmall)
            }
            Button(onClick = { /*TODO*/ }) {
                Text("View Submissions")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeacherAssignmentsScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        TeacherAssignmentsScreen(rememberNavController())
    }
}
