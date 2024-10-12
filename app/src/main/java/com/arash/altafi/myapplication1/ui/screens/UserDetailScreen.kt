package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import com.arash.altafi.myapplication1.viewmodel.UserViewModel
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserDetailScreen(
    userId: Int
) {
    val viewModel: UserViewModel = hiltViewModel()
    val user by viewModel.selectedUser.observeAsState()
    val isFavorite by viewModel.isFavorite.observeAsState(false)

    LaunchedEffect(userId) {
        viewModel.fetchUserDetails(userId)
        viewModel.checkFavorite(userId)
    }

    user?.let { user ->
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Email: ${user.email}")
            Text(text = "Phone: ${user.phone}")
            Text(text = "Website: ${user.website}")
            Text(text = "Company: ${user.company.name}")

            Spacer(modifier = Modifier.height(16.dp))

            // Like / Dislike Icon
            IconButton(onClick = { viewModel.toggleFavorite(user) }) {
                if (isFavorite) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Remove from favorites",
                        tint = Color.Red,
                        modifier = Modifier.size(48.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Add to favorites",
                        tint = Color.Gray,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}
