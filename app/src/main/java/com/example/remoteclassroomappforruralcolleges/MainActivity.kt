package com.example.remoteclassroomappforruralcolleges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.remoteclassroomappforruralcolleges.navigation.NavGraph
import com.example.remoteclassroomappforruralcolleges.ui.theme.RemoteClassroomAppForRuralCollegesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RemoteClassroomAppForRuralCollegesTheme {
                NavGraph()
            }
        }
    }
}
