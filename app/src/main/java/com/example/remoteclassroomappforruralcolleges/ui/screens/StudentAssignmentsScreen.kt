package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.GreenPrimary
import com.example.remoteclassroomappforruralcolleges.ui.theme.LightPurple
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme
import com.example.remoteclassroomappforruralcolleges.ui.theme.TextSecondary

@Composable
fun StudentAssignmentsScreen(navController: NavController) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("All", "Pending", "Submitted")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = Color.Transparent,
            contentColor = GreenPrimary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = GreenPrimary
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title, color = if (tabIndex == index) GreenPrimary else TextSecondary) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(5) { // Dummy data
                AssignmentCardItem("Assignment on AI", "Artificial Intelligence", "12/12/2024", tabIndex)
            }
        }
    }
}

@Composable
fun AssignmentCardItem(title: String, subject: String, dueDate: String, status: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = LightPurple),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text("Subject: $subject", style = MaterialTheme.typography.bodySmall, color = TextSecondary)
                Text("Due on: $dueDate", style = MaterialTheme.typography.bodySmall, color = TextSecondary)
            }
            if (status < 2) { // All or Pending
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                    shape = MaterialTheme.shapes.extraLarge,
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 24.dp, vertical = 8.dp)
                ) {
                    Text("Submit")
                }
            } else { // Submitted
                Text("Score: 8/10", style = MaterialTheme.typography.titleMedium, color = GreenPrimary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentAssignmentsScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        StudentAssignmentsScreen(rememberNavController())
    }
}
