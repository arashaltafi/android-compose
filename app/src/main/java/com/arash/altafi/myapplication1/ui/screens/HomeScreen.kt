package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arash.altafi.myapplication1.ui.component.AlerterComponent
import com.arash.altafi.myapplication1.ui.component.LottieComponent
import com.arash.altafi.myapplication1.ui.component.ShowBottomSheet
import com.arash.altafi.myapplication1.ui.component.ToastComponent
import com.arash.altafi.myapplication1.ui.theme.CustomFont
import com.arash.altafi.myapplication1.R

@Composable
fun HomeScreen(navController: NavController) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var showAlert by remember { mutableStateOf(false) }
    var showToast by remember { mutableStateOf(false) }

    if (showToast) {
        ToastComponent(
            title = "Toast Title",
            body = "Toast Body",
            icon = Icons.Default.Close,
            showToast = showToast,
            expireTime = 3000L,
        ) {
            showToast = false
        }
    }

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
            fontFamily = CustomFont,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LottieComponent(
            size = DpSize(width = 64.dp, height = 64.dp),
            loop = true,
            lottieFile = R.raw.login
        )
        Spacer(Modifier.height(32.dp))
        LottieComponent(
            size = DpSize(width = 64.dp, height = 64.dp),
            loop = true,
            lottieFile = R.raw.search
        )
        Spacer(Modifier.height(32.dp))
        LottieComponent(
            size = DpSize(width = 64.dp, height = 64.dp),
            loop = true,
            lottieFile = R.raw.internet_on
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

        OutlinedButton(
            modifier = Modifier
                .padding(top = 22.dp),
            onClick = {
                showToast = true
            },
        ) {
            Text(
                text = "show toast"
            )
        }

        OutlinedButton(
            modifier = Modifier
                .padding(top = 22.dp),
            onClick = {
                showAlert = true
            },
        ) {
            Text(
                text = "show alerter"
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 22.dp),
            onClick = {
                navController.navigate("dataStore")
            },
        ) {
            Text(
                text = "Navigate DataStoreScreen"
            )
        }

        Button(
            modifier = Modifier
                .padding(top = 22.dp),
            onClick = {
                navController.navigate("jwt")
            },
        ) {
            Text(
                text = "Navigate JwtScreen"
            )
        }

        AlerterComponent(showAlert) {
            showAlert = false
        }

        ShowBottomSheet(showBottomSheet) {
            showBottomSheet = false
        }
    }
}