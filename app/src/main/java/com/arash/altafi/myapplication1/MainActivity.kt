package com.arash.altafi.myapplication1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arash.altafi.myapplication1.ui.navigation.AppNavigation
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            NavigationComponent()
            AppNavigation()
        }
    }
}

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    // NavHost defines the navigation graph
    NavHost(navController = navController, startDestination = "app") {
        composable("app") { App(navController) }
        composable("page1") { Page1(navController) }
        composable("page2") { Page2(navController) }
        composable("page3") { Page3() }
    }
}

@Composable
fun App(navController: NavController) {
    val context = LocalContext.current

    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                .background(color = Color.Gray)
                .padding(8.dp),
            containerColor = Color.Gray,
            topBar = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .padding(8.dp),
                    text = "topBar",
                    color = Color.White
                )
            },
            bottomBar = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .padding(8.dp),
                    text = "bottomBar",
                    color = Color.White
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .border(
                        width = 10.dp,
                        color = Color.Red,
                        shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)
                    )
                    .padding(12.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    modifier = Modifier
                        .rotate(90f)
                        .alpha(0.9f),
                    text = "Test 1",
                    color = Color.White
                )
                Text(
                    modifier = Modifier
                        .padding(top = 22.dp),
                    text = "Test 2",
                    color = Color.White
                )
                Box(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .background(color = Color.Red)
                        .padding(12.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)),
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(top = 22.dp)
                        .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .background(color = Color.Green)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(shape = RoundedCornerShape(percent = 100))
                            .background(color = Color.Black)
                            .padding(12.dp)
                            .align(Alignment.Center)
                            .clickable {
                                Toast
                                    .makeText(context, "aaa", Toast.LENGTH_SHORT)
                                    .show()
                            }
                    )
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Magenta)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Yellow)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Yellow)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Magenta)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Yellow)
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color.Yellow)
                )

                Button(
                    modifier = Modifier
                        .padding(top = 22.dp),
                    onClick = {
                        navController.navigate("page1")
                    },
                ) {
                    Text(text = "navigate page1")
                }

                OutlinedButton(
                    modifier = Modifier
                        .padding(top = 22.dp),
                    onClick = {
                        navController.navigate("page2")
                    },
                ) {
                    Text(text = "navigate page2")
                }

                IconButton(
                    modifier = Modifier
                        .padding(top = 22.dp),
                    onClick = {
                        Toast.makeText(context, "IconButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = null,
                        tint = Color.Cyan
                    )
                }

                TextButton(
                    modifier = Modifier
                        .padding(top = 22.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .background(color = Color.Red),
                    onClick = {
                        Toast.makeText(context, "TextButton", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(text = "Sample Text Button", color = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        imageVector = Icons.Filled.Face,
                        contentDescription = null,
                        tint = Color.Cyan,
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                    )
                }
            }
        }
    }
}

@Composable
fun Page1(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is Page 1")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("page2") }) {
                Text(text = "Go to Page 2")
            }
        }
    }
}

@Composable
fun Page2(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "This is Page 2")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("page3") }) {
                Text(text = "Go to Page 3")
            }
        }
    }
}

@Composable
fun Page3() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "This is Page 3")
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    val navController = rememberNavController()
    App(navController = navController)
}