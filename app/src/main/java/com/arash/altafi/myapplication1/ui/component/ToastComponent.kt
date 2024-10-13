package com.arash.altafi.myapplication1.ui.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun ToastComponent(
    title: String,
    body: String,
    icon: ImageVector? = null,
    showToast: Boolean,
    expireTime: Long = 3000L,
    onDismiss: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(expireTime)
        onDismiss()
    }

    if (showToast) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .zIndex(1000f),
            contentAlignment = Alignment.TopCenter,
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color.DarkGray, shape = RoundedCornerShape(10.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
                    .clickable { onDismiss() },
                verticalAlignment = Alignment.CenterVertically
            ) {
                icon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "Toast Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp)
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = body,
                        fontSize = 14.sp,
                        color = Color.White
                    )
                }

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Toast",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.Transparent, shape = CircleShape)
                        .clickable {
                            onDismiss()
                        }
                )
            }
        }
    }
}