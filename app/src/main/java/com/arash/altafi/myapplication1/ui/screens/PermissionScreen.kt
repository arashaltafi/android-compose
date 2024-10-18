package com.arash.altafi.myapplication1.ui.screens

import android.Manifest
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.arash.altafi.myapplication1.utils.PermissionUtils

@Composable
fun PermissionScreen() {
    val context = LocalContext.current

    // Launchers for different permissions
    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        PermissionUtils.showPermissionStatus(context, Manifest.permission.CAMERA, isGranted)
    }

    val storagePermissionLauncher13 = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.all { it.value }
        PermissionUtils.showPermissionStatus(context, "READ_MEDIA_IMAGES", granted)
    }

    val storagePermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.all { it.value }
        PermissionUtils.showPermissionStatus(context, "Storage", granted)
    }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        PermissionUtils.showPermissionStatus(context, Manifest.permission.ACCESS_FINE_LOCATION, isGranted)
    }

    val contactsPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        PermissionUtils.showPermissionStatus(context, Manifest.permission.READ_CONTACTS, isGranted)
    }

    val notificationPermissionLauncher = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            PermissionUtils.showPermissionStatus(context, Manifest.permission.POST_NOTIFICATIONS, isGranted)
        }
    } else {
        null
    }

    // UI for the screen with buttons for each permission
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            if (PermissionUtils.isPermissionGranted(context, Manifest.permission.CAMERA)) {
                Toast.makeText(context, "Camera permission already granted", Toast.LENGTH_SHORT).show()
            } else {
                cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }) {
            Text(text = "Request Camera Permission")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                if (PermissionUtils.isPermissionGranted(context, Manifest.permission.READ_MEDIA_IMAGES)) {
                    Toast.makeText(context, "READ_MEDIA_IMAGES permissions already granted", Toast.LENGTH_SHORT).show()
                } else {
                    storagePermissionLauncher13.launch(
                        arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
                    )
                }
            } else {
                if (PermissionUtils.isPermissionGranted(context, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                    PermissionUtils.isPermissionGranted(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                ) {
                    Toast.makeText(context, "Storage permissions already granted", Toast.LENGTH_SHORT).show()
                } else {
                    storagePermissionLauncher.launch(
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    )
                }
            }
        }) {
            Text(text = "Request Storage Permissions")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (PermissionUtils.isPermissionGranted(context, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(context, "Location permission already granted", Toast.LENGTH_SHORT).show()
            } else {
                locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }) {
            Text(text = "Request Location Permission")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (PermissionUtils.isPermissionGranted(context, Manifest.permission.READ_CONTACTS)) {
                Toast.makeText(context, "Contacts permission already granted", Toast.LENGTH_SHORT).show()
            } else {
                contactsPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
            }
        }) {
            Text(text = "Request Contacts Permission")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Button(onClick = {
                notificationPermissionLauncher?.launch(Manifest.permission.POST_NOTIFICATIONS)
            }) {
                Text(text = "Request Notification Permission")
            }
        }
    }
}
