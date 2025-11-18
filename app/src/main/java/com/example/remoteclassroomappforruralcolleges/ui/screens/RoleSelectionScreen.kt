package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remoteclassroomappforruralcolleges.ui.theme.BlueAccent
import com.example.remoteclassroomappforruralcolleges.ui.theme.GreenPrimary
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.TextSecondary

@Composable
fun RoleSelectionScreen(onRoleSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome!", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Select your role to continue", style = MaterialTheme.typography.bodyLarge, color = TextSecondary)
        Spacer(modifier = Modifier.height(32.dp))
        RoleCard(
            icon = Icons.Default.School,
            title = "Student",
            subtitle = "Access live classes, recordings, and assignments",
            iconBackgroundColor = BlueAccent,
            onClick = { onRoleSelected("student") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        RoleCard(
            icon = Icons.Default.Person,
            title = "Teacher",
            subtitle = "Create classes, upload content, and grade assignments",
            iconBackgroundColor = GreenPrimary,
            onClick = { onRoleSelected("teacher") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoleCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    iconBackgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(iconBackgroundColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(icon, contentDescription = title, tint = Color.White, modifier = Modifier.size(32.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoleSelectionScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        RoleSelectionScreen(onRoleSelected = {})
    }
}
