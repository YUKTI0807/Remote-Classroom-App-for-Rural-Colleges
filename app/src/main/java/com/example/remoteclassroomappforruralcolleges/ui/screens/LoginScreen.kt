package com.example.remoteclassroomappforruralcolleges.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme

@Composable
fun LoginScreen(navController: NavController, role: String) {
    var identifier by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppLogo() // Using the AppLogo from WelcomeScreen.kt
        Spacer(modifier = Modifier.height(24.dp))
        Text("Login as $role", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = identifier,
            onValueChange = { identifier = it },
            label = { Text("Phone or Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password or OTP") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { 
                if (role.equals("student", ignoreCase = true)) {
                    navController.navigate("studentHome")
                } else {
                    navController.navigate("teacherHome")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        TextButton(onClick = { navController.navigate("studentHome") }) {
            Text("Continue as Guest")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "For low bandwidth, use phone + OTP for faster login.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    RemoteClassroomAppForRuralCollegesTheme {
        LoginScreen(rememberNavController(), "Student")
    }
}
