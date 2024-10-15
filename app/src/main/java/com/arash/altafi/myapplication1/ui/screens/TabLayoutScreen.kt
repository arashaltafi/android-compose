package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.arash.altafi.myapplication1.ui.navigation.getTabItems
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme

@Composable
fun TabLayoutScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            ) {
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                ) {
                    getTabItems(navController).forEachIndexed { index, tabItem ->
                        Tab(
                            selected = index == selectedTabIndex,
                            onClick = { selectedTabIndex = index },
                            text = {
                                Text(text = tabItem.title)
                            },
                            icon = {
                                Icon(
                                    imageVector =
                                    if (index == selectedTabIndex) {
                                        tabItem.selectedIcon
                                    } else {
                                        tabItem.unSelectedIcon
                                    },
                                    contentDescription = tabItem.title
                                )
                            }
                        )
                    }
                }

                getTabItems(navController).getOrNull(selectedTabIndex)?.screen?.invoke()
            }
        }
    }
}