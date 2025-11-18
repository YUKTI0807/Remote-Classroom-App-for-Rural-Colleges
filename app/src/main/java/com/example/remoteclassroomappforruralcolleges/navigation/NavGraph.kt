package com.example.remoteclassroomappforruralcolleges.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remoteclassroomappforruralcolleges.ui.screens.*

@Composable
fun NavGraph(startDestination: String = "welcome") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("welcome") {
            WelcomeScreen(onGetStarted = {
                navController.navigate("roleSelection")
            })
        }
        composable("roleSelection"){
            RoleSelectionScreen(onRoleSelected = { role ->
                navController.navigate("login/$role")
            })
        }
        composable("login/{role}") { backStackEntry ->
            val role = backStackEntry.arguments?.getString("role") ?: "guest"
            LoginScreen(navController = navController, role = role)
        }
        composable("studentHome") { StudentHomeScreen(navController) }
        composable("teacherHome") { TeacherHomeScreen(navController) }
        composable("studentClasses") { StudentClassesScreen(navController) }
        composable("teacherClasses") { TeacherClassesScreen(navController) }
        composable("studentAssignments") { StudentAssignmentsScreen(navController) }
        composable("teacherAssignments") { TeacherAssignmentsScreen(navController) }
        composable("profile/{role}") {backStackEntry ->
            val role = backStackEntry.arguments?.getString("role") ?: "guest"
            ProfileScreen(navController, role)
        }
    }
}
