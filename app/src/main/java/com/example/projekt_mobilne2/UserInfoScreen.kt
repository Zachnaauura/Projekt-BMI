package com.example.projekt_mobilne2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun UserInfoScreen(
    navController: NavController,
    name: String,
    surname: String,
    age: String,
    height: String,
    weight: String,
    gender: String
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Name: $name", color = MaterialTheme.colorScheme.onSurface)
        Text(text = "Surname: $surname", color = MaterialTheme.colorScheme.onSurface)
        Text(text = "Age: $age", color = MaterialTheme.colorScheme.onSurface)
        Text(text = "Height: $height", color = MaterialTheme.colorScheme.onSurface)
        Text(text = "Weight: $weight", color = MaterialTheme.colorScheme.onSurface)
        Text(text = "Gender: $gender", color = MaterialTheme.colorScheme.onSurface)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("form") }, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)) {
            Text("Back to Main Screen", color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}