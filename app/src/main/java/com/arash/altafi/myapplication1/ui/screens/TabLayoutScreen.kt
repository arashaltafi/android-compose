package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.arash.altafi.myapplication1.ui.navigation.getTabItems
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme

@Composable
fun TabLayoutScreen(navController: NavHostController) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabItemSize = getTabItems(navController).size
    val pagerState = rememberPagerState { tabItemSize }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

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

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        getTabItems(navController).getOrNull(index)?.screen?.invoke()
                    }
                }
            }
        }
    }
}