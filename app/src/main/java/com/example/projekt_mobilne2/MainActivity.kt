package com.example.projekt_mobilne2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projekt_mobilne2.ui.theme.ComposeTheme
import com.example.projekt_mobilne2.screens.UserFormScreen
import com.example.projekt_mobilne2.screens.UserInfoScreen
import com.example.projekt_mobilne2.screens.BMIScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            ComposeTheme(darkTheme = isDarkTheme) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MyApp(isDarkTheme) { isDarkTheme = !isDarkTheme }
                }
            }
        }
    }
}

@Composable
fun MyApp(isDarkTheme: Boolean, toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = toggleTheme, modifier = Modifier.fillMaxWidth()) {
            Text(if (isDarkTheme) "Switch to Light Mode" else "Switch to Dark Mode")
        }
        NavHost(navController, startDestination = "form", modifier = Modifier.weight(1f)) {
            composable("form") { UserFormScreen(navController) }
            composable("info/{name}/{surname}/{age}/{height}/{weight}/{gender}") { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val surname = backStackEntry.arguments?.getString("surname") ?: ""
                val age = backStackEntry.arguments?.getString("age") ?: ""
                val height = backStackEntry.arguments?.getString("height") ?: ""
                val weight = backStackEntry.arguments?.getString("weight") ?: ""
                val gender = backStackEntry.arguments?.getString("gender") ?: ""
                UserInfoScreen(navController, name, surname, age, height, weight, gender)
            }
            composable("bmi/{name}/{height}/{weight}") { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val height = backStackEntry.arguments?.getString("height")?.toFloatOrNull() ?: 0f
                val weight = backStackEntry.arguments?.getString("weight")?.toFloatOrNull() ?: 0f
                BMIScreen(navController, name, height, weight)
            }
        }
    }
}