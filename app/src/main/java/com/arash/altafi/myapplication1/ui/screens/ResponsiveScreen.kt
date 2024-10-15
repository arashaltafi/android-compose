package com.arash.altafi.myapplication1.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.arash.altafi.myapplication1.utils.WindowType
import com.arash.altafi.myapplication1.utils.rememberWindowSize

@Composable
fun ResponsiveScreen(navController: NavController) {
    val windowSize = rememberWindowSize()
    when (windowSize.width) {
        WindowType.SMALL -> ResponsiveScreenPortrait(navController)
        WindowType.MEDIUM -> ResponsiveScreenLandScape(navController)
        WindowType.LARGE -> ResponsiveScreenLandScape(navController)
    }
}

@Composable
fun ResponsiveScreenPortrait(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("tabLayout")
            }
        ) {
            Text("Navigate To TabLayout")
        }

        AsyncImage(
            model = "https://arashaltafi.ir/Social_Media/story-04.jpg",
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .width(250.dp)
                .height(250.dp)
                .clip(CircleShape)
                .shadow(10.dp)
                .border(1.dp, Color.Blue, CircleShape),
            contentScale = ContentScale.None,
        )

        PersonalData("Name", "Arash")
        PersonalData("Email", "arashaltafi1377@gmail.com")
        PersonalData("Phone", "09187677641")
    }
}

@Composable
fun ResponsiveScreenLandScape(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = "https://arashaltafi.ir/Social_Media/story-04.jpg",
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp)
                    .height(250.dp)
                    .clip(CircleShape)
                    .shadow(10.dp)
                    .border(1.dp, Color.Blue, CircleShape),
                contentScale = ContentScale.None,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            PersonalData("Name", "Arash")
            PersonalData("Email", "arashaltafi1377@gmail.com")
            PersonalData("Phone", "09187677641")
        }
    }
}

@Composable
fun PersonalData(title: String, data: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = data,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

}