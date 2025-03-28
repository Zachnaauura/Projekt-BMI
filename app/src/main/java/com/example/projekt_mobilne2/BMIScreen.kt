package com.example.projekt_mobilne2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BMIScreen(navController: NavController, name: String, height: Float, weight: Float) {
    val bmi = weight / ((height / 100) * (height / 100))
    val message = when {
        bmi < 18.5 -> "Hej $name, jesteś poniżej normy. Twoje BMI wynosi $bmi."
        bmi < 24.9 -> "Hej $name, jesteś w świetnej formie! Twoje BMI wynosi $bmi."
        else -> "Hej $name, Twoje BMI wynosi $bmi, warto zadbać o zdrowie!"
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = message, color = Color.Blue)
        Button(onClick = { navController.navigate("form") }, colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
            Text("Back to Main Screen", color = Color.White)
        }
    }
}