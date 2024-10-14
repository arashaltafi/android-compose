package com.arash.altafi.myapplication1

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arash.altafi.myapplication1.ui.navigation.AppNavigation
import com.arash.altafi.myapplication1.ui.screens.ResponsiveScreen
import com.arash.altafi.myapplication1.ui.screens.Test
import com.arash.altafi.myapplication1.utils.language.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LocaleUtils.setLocale(this)
        enableEdgeToEdge()
        setContent {
//            Test()
            ResponsiveScreen()
//            AppNavigation()
        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleUtils.setLocale(newBase))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleUtils.setLocale(this)
    }
}