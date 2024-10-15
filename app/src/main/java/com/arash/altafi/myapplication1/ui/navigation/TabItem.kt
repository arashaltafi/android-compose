package com.arash.altafi.myapplication1.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(
    val title: String,
    val unSelectedIcon: ImageVector,
    val selectedIcon: ImageVector
)

fun getTabItems(): List<TabItem> {
    return listOf(
        TabItem(
            title = "Home",
            unSelectedIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home
        ),
        TabItem(
            title = "Search",
            unSelectedIcon = Icons.Outlined.Search,
            selectedIcon = Icons.Filled.Search
        ),
        TabItem(
            title = "Profile",
            unSelectedIcon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Filled.AccountCircle
        )
    )
}