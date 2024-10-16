package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.arash.altafi.myapplication1.ui.theme.CustomFont

@Composable
fun DeepLinkScreen(userId: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "DeepLinkScreen $userId",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            fontFamily = CustomFont
        )
    }
}