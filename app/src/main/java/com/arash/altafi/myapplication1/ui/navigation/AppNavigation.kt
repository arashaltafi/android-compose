package com.arash.altafi.myapplication1.ui.navigation

import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.arash.altafi.myapplication1.ui.component.BackPressHandler
import com.arash.altafi.myapplication1.ui.screens.HomeScreen
import com.arash.altafi.myapplication1.ui.screens.ResponsiveScreen
import com.arash.altafi.myapplication1.ui.screens.SplashScreen
import com.arash.altafi.myapplication1.ui.screens.UserDetailScreen
import com.arash.altafi.myapplication1.ui.screens.UserListScreen
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val fabVisible by remember { mutableStateOf(true) }

    val darkTheme: Boolean = isSystemInDarkTheme()
    var isDarkTheme by rememberSaveable { mutableStateOf(darkTheme) }

    val context = LocalContext.current
    val activity = (context as? Activity)

    var doubleBackToExitPressedOnce by remember { mutableStateOf(false) }
    var navigationSelectedItem by remember { mutableIntStateOf(0) }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    val isSplashScreen = currentDestination == "splash"
    val isHomeScreen = currentDestination == "home"

    MyApplication1Theme(
        darkTheme = isDarkTheme
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                if (!isSplashScreen) {
                    @OptIn(ExperimentalMaterial3Api::class)
                    TopAppBar(
                        title = { Text("اپلیکیشن اندروید") },
                        navigationIcon = {
                            if (!isHomeScreen) {
                                IconButton(
                                    onClick = {
                                        if (navController.previousBackStackEntry != null) {
                                            // Pop the backstack if there is a previous route
                                            navController.popBackStack()
                                            navigationSelectedItem = 0
                                        } else {
                                            // Handle double back press to exit the app
                                            if (doubleBackToExitPressedOnce) {
                                                // Exit the app if back is pressed twice within 5 seconds
                                                activity?.finish()
                                            } else {
                                                // Show the toast message and start a 5-second timer
                                                doubleBackToExitPressedOnce = true
                                                Toast.makeText(
                                                    context,
                                                    "برای خروج یک بار دیگر دکمه برگشت را بزنید",
                                                    Toast.LENGTH_SHORT
                                                ).show()

                                                // Reset the flag after 5 seconds using coroutine
                                                CoroutineScope(Dispatchers.Main).launch {
                                                    delay(5000)  // 5-second delay
                                                    doubleBackToExitPressedOnce = false
                                                }
                                            }
                                        }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Back",
                                        tint = Color.Cyan
                                    )
                                }
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    isDarkTheme = !isDarkTheme
                                }
                            ) {
                                Icon(
                                    imageVector = if (isDarkTheme) Icons.Filled.Add else Icons.Filled.Star,
                                    contentDescription = if (isDarkTheme) "Switch to Light Theme" else "Switch to Dark Theme",
                                    tint = Color.White
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = Color.White,
                        )
                    )
                }
            },
            bottomBar = {
                if (!isSplashScreen) {
                    NavigationBar {
                        //getting the list of bottom navigation items for our data class
                        BottomNavigationItem().bottomNavigationItems()
                            .forEachIndexed { index, navigationItem ->

                                //iterating all items with their respective indexes
                                NavigationBarItem(
                                    selected = index == navigationSelectedItem,
                                    label = {
                                        Text(navigationItem.label)
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if (navigationItem.badgeCount != 0) {
                                                    Badge {
                                                        Text(text = navigationItem.badgeCount.toString())
                                                    }
                                                } else {
                                                    Badge()
                                                }
                                            },
                                        ) {
                                            Icon(
                                                navigationItem.icon,
                                                contentDescription = navigationItem.label
                                            )
                                        }
                                    },
                                    onClick = {
                                        navigationSelectedItem = index
                                        navController.navigate(navigationItem.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }
                                )
                            }
                    }
                }
            },
            floatingActionButton = {
                AnimatedVisibility(visible = fabVisible && !isSplashScreen) {
                    FloatingActionButton(
                        onClick = {
                            Toast.makeText(context, "FAB clicked", Toast.LENGTH_SHORT).show()
                        },
                        containerColor = MaterialTheme.colorScheme.secondary
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Add")
                    }
                }
            },
            floatingActionButtonPosition = FabPosition.End,
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable("splash") {
                    SplashScreen(navController)
                }
                composable("home") {
                    HomeScreen()
                }
                composable("search") {
                    ResponsiveScreen()
                }
                composable(
                    "profile",
                    enterTransition = {
                        return@composable slideIntoContainer(
                            AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                        )
                    },
                    popExitTransition = {
                        return@composable slideOutOfContainer(
                            AnimatedContentTransitionScope.SlideDirection.End, spring(1f)
                        )
                    },
                ) {
                    UserListScreen(navController)
                }
                composable("userDetail/{userId}") { backStackEntry ->
                    val userId = backStackEntry.arguments?.getString("userId")?.toInt() ?: 0
                    UserDetailScreen(userId)
                }
            }

            BackPressHandler(navController) { newItem ->
                navigationSelectedItem = newItem
            }
        }
    }
}