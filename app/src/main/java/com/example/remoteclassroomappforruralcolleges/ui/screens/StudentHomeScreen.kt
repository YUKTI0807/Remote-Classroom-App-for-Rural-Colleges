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
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.PlayArrow
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
fun StudentHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp)) // Top Space
        GreetingHeader(navController, "Yukti", "Sem 5")
        Spacer(modifier = Modifier.height(24.dp))
        LiveNowCard()
        Spacer(modifier = Modifier.height(24.dp))
        QuickActionsSection(navController)
        Spacer(modifier = Modifier.height(24.dp))
        SubjectsSection()
    }
}

@Composable
fun GreetingHeader(navController: NavController, name: String, semester: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Welcome back,", style = MaterialTheme.typography.bodyLarge)
            Text(name, style = MaterialTheme.typography.headlineMedium)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
             Box(
                modifier = Modifier
                    .background(BlueAccent, CircleShape)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(semester, color = Color.White)
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { navController.navigate("profile/student") }) {
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile", modifier = Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun LiveNowCard() {
    Column {
        Text("Live Now", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = GreenPrimary),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("LIVE", color = Color.White, style = MaterialTheme.typography.bodySmall)
                Text("Machine Learning Fundamentals", color = Color.White, style = MaterialTheme.typography.titleMedium)
                Text("Dr. Rajesh Kumar", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.White)
                    Text("10:00 AM", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                    Spacer(modifier = Modifier.weight(1f))
                    Text("45 students", color = Color.White, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun QuickActionsSection(navController: NavController) {
    Column {
        Text("Quick Actions", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            QuickActionCard(
                icon = Icons.Default.PlayArrow,
                title = "Recorded",
                subtitle = "Classes",
                iconBackgroundColor = BlueAccent,
                cardBackgroundColor = LightPurple,
                onClick = { navController.navigate("studentClasses") }
            )
            QuickActionCard(
                icon = Icons.Default.Assignment,
                title = "Assignments",
                subtitle = "2 pending",
                iconBackgroundColor = OrangeAccent,
                cardBackgroundColor = LightOrange,
                onClick = { navController.navigate("studentAssignments") }
            )
            QuickActionCard(
                icon = Icons.Default.Download,
                title = "Offline",
                subtitle = "Downloads",
                iconBackgroundColor = GreenPrimary,
                cardBackgroundColor = LightPurple,
                onClick = { /* Todo: Offline Screen */ }
            )
        }
    }
}

@Composable
fun QuickActionCard(
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
fun SubjectsSection() {
    Column {
        Text(text = "Your Subjects", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        // Replace with a lazy list for performance
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            SubjectRow("Artificial Intelligence", "120 students")
            SubjectRow("Machine Learning", "110 students")
            SubjectRow("Data Structures", "130 students")
        }
    }
}

@Composable
fun SubjectRow(subject: String, students: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = SubjectBackground),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(subject, style = MaterialTheme.typography.bodyLarge)
            Text(students, color = TextSecondary, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentHomeScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        StudentHomeScreen(rememberNavController())
    }
}
