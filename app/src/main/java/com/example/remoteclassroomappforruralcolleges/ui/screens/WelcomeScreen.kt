package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Duo
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.SignalCellularAlt
import androidx.compose.material.icons.outlined.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remoteclassroomappforruralcolleges.ui.theme.GreenPrimary
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.TextSecondary

@Composable
fun WelcomeScreen(onGetStarted: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        AppLogo()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Rural Classroom",
            style = MaterialTheme.typography.headlineLarge,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Education Anywhere, Anytime",
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondary
        )

        Spacer(modifier = Modifier.height(48.dp))

        FeatureRow(icon = Icons.Outlined.Duo, text = "Live & Recorded Classes")
        Spacer(modifier = Modifier.height(16.dp))
        FeatureRow(icon = Icons.Outlined.SignalCellularAlt, text = "Low Bandwidth Optimized")
        Spacer(modifier = Modifier.height(16.dp))
        FeatureRow(icon = Icons.Outlined.WifiOff, text = "Offline Learning")

        Spacer(modifier = Modifier.weight(2f))

        Button(
            onClick = onGetStarted,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text("Get Started", modifier = Modifier.padding(vertical = 8.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Available in: English, हिंदी, ગુજરાતી",
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondary
        )
    }
}

@Composable
fun AppLogo() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(GreenPrimary, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Outlined.MenuBook,
            contentDescription = "App Logo",
            modifier = Modifier.size(60.dp),
            tint = Color.White
        )
    }
}

@Composable
fun FeatureRow(icon: ImageVector, text: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = TextSecondary)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = text, style = MaterialTheme.typography.bodyLarge)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        WelcomeScreen(onGetStarted = {})
    }
}
