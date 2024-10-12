package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arash.altafi.myapplication1.data.model.ResponseUsers
import com.arash.altafi.myapplication1.viewmodel.UserViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserListScreen(
    navController: NavController
) {
    val viewModel: UserViewModel = hiltViewModel()
    val users by viewModel.users.observeAsState(emptyList<ResponseUsers>())
    val error by viewModel.liveError.observeAsState(false)
    val loading by viewModel.liveLoading.observeAsState(false)

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("در حال دریافت اطلاعات ...")
        }
        return
    }

    if (error) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("خطایی رخ داده است")
        }

        return
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users.size) { user ->
            UserListItem(user = users[user]) {
                navController.navigate("userDetail/${users[user].id}")
            }
        }

        items(users.size) { user ->
            UserListItem(user = users[user]) {
                navController.navigate("userDetail/${users[user].id}")
            }
        }
    }
}

@Composable
fun UserListItem(user: ResponseUsers, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = user.name, style = MaterialTheme.typography.bodySmall)
            Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
