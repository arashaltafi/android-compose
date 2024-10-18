package com.arash.altafi.myapplication1.ui.navigation

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.arash.altafi.myapplication1.R
import com.arash.altafi.myapplication1.ui.component.BackPressHandler
import com.arash.altafi.myapplication1.ui.component.ImageSliderScreen
import com.arash.altafi.myapplication1.ui.screens.DataStoreScreen
import com.arash.altafi.myapplication1.ui.screens.DeepLinkScreen
import com.arash.altafi.myapplication1.ui.screens.HomeScreen
import com.arash.altafi.myapplication1.ui.screens.ResponsiveScreen
import com.arash.altafi.myapplication1.ui.screens.SplashScreen
import com.arash.altafi.myapplication1.ui.screens.TabLayoutScreen
import com.arash.altafi.myapplication1.ui.screens.Test
import com.arash.altafi.myapplication1.ui.screens.UserDetailScreen
import com.arash.altafi.myapplication1.ui.screens.UserListScreen
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme
import com.arash.altafi.myapplication1.viewmodel.DataStoreViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val dataStoreViewModel: DataStoreViewModel = hiltViewModel()

    LaunchedEffect(Unit) {
        dataStoreViewModel.getTheme()
    }

    val fabVisible by remember { mutableStateOf(true) }

    val darkTheme: Boolean = isSystemInDarkTheme()
    val theme by dataStoreViewModel.cachedTheme.observeAsState()

    LaunchedEffect(theme) {
        val isDark = if (darkTheme) "dark" else "light"
        if (theme == "") {
            dataStoreViewModel.setTheme(isDark)
        }
    }

    val context = LocalContext.current
    val activity = (context as? Activity)

    var doubleBackToExitPressedOnce by remember { mutableStateOf(false) }
    var navigationSelectedItem by remember { mutableIntStateOf(0) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val coroutineScope = rememberCoroutineScope()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route
    val isSplashScreen = currentDestination == "splash"
    val isHomeScreen = currentDestination == "home"
    val allowBottomBar = arrayOf("home", "search", "profile", "test")

    MyApplication1Theme(
        darkTheme = theme == "dark"
    ) {
        ModalNavigationDrawer(
            gesturesEnabled = true,
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = colorResource(R.color.gray_200),
                    drawerContentColor = colorResource(R.color.white),
                    drawerShape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp),
                ) {
                    Spacer(Modifier.height(16.dp))
                    bottomNavigationItems().forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding),
                            label = { Text(item.label) },
                            selected = index == selectedItemIndex,
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.label
                                )
                            },
                            badge = {
                                if (item.badgeCount > 0) {
                                    Badge {
                                        Text(item.badgeCount.toString())
                                    }
                                } else {
                                    Badge()
                                }
                            },
                            onClick = {
                                navController.navigate(item.label)
                                selectedItemIndex = index
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                            }
                        )
                    }
                }
            },
            drawerState = drawerState,
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    if (!isSplashScreen) {
                        @OptIn(ExperimentalMaterial3Api::class)
                        TopAppBar(
                            title = {
                                Text("اپلیکیشن تست")
                            },
                            navigationIcon = {
                                Row {
                                    IconButton(
                                        onClick = {
                                            coroutineScope.launch {
                                                drawerState.open()
                                            }
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Menu,
                                            contentDescription = "Menu",
                                            tint = Color.White
                                        )
                                    }
                                }
                            },
                            actions = {
                                Row {
                                    IconButton(
                                        onClick = {
                                            dataStoreViewModel.changeTheme()
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = if (theme == "dark") R.drawable.round_light_mode_24 else R.drawable.round_dark_mode_24),
                                            contentDescription = if (theme == "dark") "Switch to Light Theme" else "Switch to Dark Theme",
                                            tint = Color.White
                                        )
                                    }
                                    if (!isHomeScreen) {
                                        IconButton(
                                            onClick = {
                                                if (currentDestination !in allowBottomBar) {
                                                    navController.popBackStack()
                                                } else if (navController.previousBackStackEntry != null) {
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
                                                        coroutineScope.launch {
                                                            delay(5000)  // 5-second delay
                                                            doubleBackToExitPressedOnce = false
                                                        }
                                                    }
                                                }
                                            },
                                        ) {
                                            Icon(
                                                modifier = Modifier.rotate(180f),
                                                painter = painterResource(id = R.drawable.round_arrow_back_24),
                                                contentDescription = "Back",
                                                tint = Color.White
                                            )
                                        }
                                    }
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
                    if (currentDestination in allowBottomBar) {
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
                    startDestination = "splash",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable("test") {
                        Test()
                    }
                    composable("dataStore") {
                        DataStoreScreen()
                    }
                    composable("splash") {
                        SplashScreen(navController)
                    }
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("slider") {
                        ImageSliderScreen()
                    }
                    composable("search") {
                        ResponsiveScreen(navController)
                    }
                    composable("tabLayout") {
                        TabLayoutScreen(navController)
                    }
                    composable(
                        route = "deepLink",
                        deepLinks = listOf(
                            navDeepLink {
                                uriPattern = "https://arashaltafi.ir/{id}"
                                action = Intent.ACTION_VIEW
                            }
                        ),
                        arguments = listOf(
                            navArgument("id") {
                                type = NavType.IntType
                                defaultValue = 0
                            }
                        )
                    ) { backStackEntry ->
                        Log.i("test123321", "AppNavigation: ${backStackEntry.arguments}")
                        val userId = backStackEntry.arguments?.getInt("id") ?: 0
                        DeepLinkScreen(userId)
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
                    if (currentDestination in allowBottomBar)
                        navigationSelectedItem = newItem
                }
            }
        }
    }
}