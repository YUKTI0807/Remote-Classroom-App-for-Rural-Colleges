package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.BlueAccent
import com.example.remoteclassroomappforruralcolleges.ui.theme.GreenPrimary
import com.example.remoteclassroomappforruralcolleges.ui.theme.LightOrange
import com.example.remoteclassroomappforruralcolleges.ui.theme.LightPurple
import com.example.remoteclassroomappforruralcolleges.ui.theme.OrangeAccent
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.SubjectBackground
import com.example.remoteclassroomappforruralcolleges.ui.theme.TextSecondary

@Composable
fun TeacherHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp)) // Top Space
        TeacherGreetingHeader(navController, "Jiya Ma'am", "Computer Science")
        Spacer(modifier = Modifier.height(24.dp))
        ActiveCard()
        Spacer(modifier = Modifier.height(24.dp))
        TeacherQuickActionsSection(navController)
        Spacer(modifier = Modifier.height(24.dp))
        TeacherSubjectsSection()
    }
}

@Composable
fun TeacherGreetingHeader(navController: NavController, name: String, department: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Good morning,", style = MaterialTheme.typography.bodyLarge)
            Text(name, style = MaterialTheme.typography.headlineSmall)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .background(GreenPrimary, CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(department, color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { navController.navigate("profile/teacher") }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile", modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun ActiveCard() {
    Column {
        Text("Active Class", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = GreenPrimary),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("LIVE NOW", color = Color.White, style = MaterialTheme.typography.bodySmall)
                Text("Machine Learning Fundamentals", color = Color.White, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("45 students joined", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { /*TODO*/ }) {
                        Text("Manage")
                    }
                }
            }
        }
    }
}

@Composable
fun TeacherQuickActionsSection(navController: NavController) {
    Column {
        Text("Quick Actions", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            TeacherQuickActionCard(
                icon = Icons.Default.PlayArrow,
                title = "Start",
                subtitle = "Live Class",
                iconBackgroundColor = GreenPrimary,
                cardBackgroundColor = LightPurple
            ) {
                // TODO: Start Live Class
            }
            TeacherQuickActionCard(
                icon = Icons.Default.Videocam,
                title = "Upload",
                subtitle = "Recording",
                iconBackgroundColor = BlueAccent,
                cardBackgroundColor = LightOrange
            ) {
                navController.navigate("teacherClasses")
            }
            TeacherQuickActionCard(
                icon = Icons.Default.Assignment,
                title = "Create",
                subtitle = "Assignment",
                iconBackgroundColor = OrangeAccent,
                cardBackgroundColor = LightPurple
            ) {
                navController.navigate("teacherAssignments")
            }
        }
    }
}

@Composable
fun TeacherQuickActionCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconBackgroundColor: Color,
    cardBackgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(iconBackgroundColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = title, tint = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(title, style = MaterialTheme.typography.bodyMedium)
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = TextSecondary)
        }
    }
}

@Composable
fun TeacherSubjectsSection() {
    Column {
        Text(text = "Your Subjects", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        // Replace with a lazy list for performance
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            TeacherSubjectRow("Artificial Intelligence", "120 students", "15 classes", "8 assignments")
            TeacherSubjectRow("Machine Learning", "110 students", "12 classes", "6 assignments")
        }
    }
}

@Composable
fun TeacherSubjectRow(subject: String, students: String, classes: String, assignments: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SubjectBackground),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(subject, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text(students, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
                Text(classes, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
                Text(assignments, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TeacherHomeScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        TeacherHomeScreen(rememberNavController())
    }
}
