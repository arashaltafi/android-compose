package com.arash.altafi.myapplication1.ui.navigation

import com.arash.altafi.myapplication1.R

data class NavigationDrawerItem(
    val label: String,
    val icon: Int,
    val badgeCount: Int,
    val selected: Boolean,
)

fun bottomNavigationItems(): List<NavigationDrawerItem> {
    return listOf(
        NavigationDrawerItem(
            label = "home",
            icon = R.drawable.gift_icon,
            badgeCount = 4,
            selected = true,
        ),
        NavigationDrawerItem(
            label = "search",
            icon = R.drawable.gift_icon,
            badgeCount = 0,
            selected = false,
        ),
        NavigationDrawerItem(
            label = "account",
            icon = R.drawable.gift_icon,
            badgeCount = 4,
            selected = false,
        ),
        NavigationDrawerItem(
            label = "test",
            icon = R.drawable.gift_icon,
            badgeCount = 1,
            selected = false,
        ),
    )
}