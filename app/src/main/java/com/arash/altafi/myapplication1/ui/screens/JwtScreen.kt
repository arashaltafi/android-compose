package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.*
import com.arash.altafi.myapplication1.utils.JwtUtils

@Composable
fun JwtScreen() {
    var inputData by remember { mutableStateOf("user_id:123") }
    var token by remember { mutableStateOf("") }
    var verificationResult by remember { mutableStateOf(false) }
    var decodedData by remember { mutableStateOf<Map<String, Any>?>(null) }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            // Input Data
            TextField(
                value = inputData,
                onValueChange = { inputData = it },
                label = { Text("Input Data (e.g., user_id:123)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Generate Token Button
            Button(onClick = {
                val data = mapOf("user_id" to inputData)
                token = JwtUtils.generateToken(data, 1) // Token expires in 1 day
            }) {
                Text("Generate JWT Token")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display Token
            if (token.isNotEmpty()) {
                Text("Generated Token: $token", modifier = Modifier.padding(8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Verify Token Button
            Button(onClick = {
                verificationResult = JwtUtils.verifyToken(token)
            }) {
                Text("Verify Token")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display Verification Result
            Text("Token Valid: $verificationResult", modifier = Modifier.padding(8.dp))

            Spacer(modifier = Modifier.height(16.dp))

            // Decode Token Button
            Button(onClick = {
                decodedData = JwtUtils.decodeToken(token)
            }) {
                Text("Decode Token")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display Decoded Data
            decodedData?.let {
                Text("Decoded Data: $it", modifier = Modifier.padding(8.dp))
            }
        }
    }
}