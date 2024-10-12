package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arash.altafi.myapplication1.ui.component.ShowBottomSheet
import com.arash.altafi.myapplication1.ui.theme.CustomFont

@Composable
fun HomeScreen() {
    var showBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Home Screen",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            fontFamily = CustomFont
        )

        OutlinedButton(
            modifier = Modifier
                .padding(top = 22.dp),
            onClick = {
                showBottomSheet = true
            },
        ) {
            Text(
                text = "show bottomSheet"
            )
        }

        ShowBottomSheet(showBottomSheet) {
            showBottomSheet = false
        }
    }
}