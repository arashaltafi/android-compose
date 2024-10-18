package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.arash.altafi.myapplication1.viewmodel.DataStoreViewModel

@Composable
fun DataStoreScreen() {
    val viewModel: DataStoreViewModel = hiltViewModel()

    val token by viewModel.cachedToken.observeAsState(initial = "")
    val name by viewModel.cachedName.observeAsState(initial = "")
    val theme by viewModel.cachedTheme.observeAsState(initial = "")
    val isError by viewModel.liveError.observeAsState(false)
    val isLoading by viewModel.liveLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.getToken()
        viewModel.getName()
        viewModel.getTheme()
    }

    Column {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (isError) {
            Text("Error loading data.")
        } else {
            Text(text = "Token: $token")
            Text(text = "Name: $name")
            Text(text = "Theme: $theme")

            Button(
                onClick = {
                    viewModel.setToken(
                        "W1lIjoiYXJhc2giLCJmYW1pbHkiOiJhbHRhZmkiLCJhZ2UiOiIyNiIsImFsZyI6IkhTMjU2In0.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.BfXycSCvyVBmFY_uavfcKM2afidLBwTvb_f-qB"
                    )
                }
            ) {
                Text("Save Token")
            }
            Button(
                onClick = {
                    viewModel.setName("arash")
                }
            ) {
                Text("Save Name")
            }
            Button(
                onClick = {
                    viewModel.changeTheme()
                }
            ) {
                if(theme == "dark") {
                    Text("set light")
                } else {
                    Text("set dark")
                }
            }
        }
    }
}