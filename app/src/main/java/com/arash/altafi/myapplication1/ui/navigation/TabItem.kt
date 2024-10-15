package com.arash.altafi.myapplication1.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.arash.altafi.myapplication1.ui.component.ImageSliderScreen
import com.arash.altafi.myapplication1.ui.screens.ResponsiveScreen
import com.arash.altafi.myapplication1.ui.screens.UserListScreen

data class TabItem(
    val title: String,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: @Composable () -> Unit
)

@Composable
fun getTabItems(navController: NavController): List<TabItem> {
    return listOf(
        TabItem(
            title = "slider",
            unSelectedIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home,
            screen = { ImageSliderScreen() }
        ),
        TabItem(
            title = "Search",
            unSelectedIcon = Icons.Outlined.Search,
            selectedIcon = Icons.Filled.Search,
            screen = { ResponsiveScreen(navController) }
        ),
        TabItem(
            title = "Profile",
            unSelectedIcon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Filled.AccountCircle,
            screen = { UserListScreen(navController) }
        )
    )
}