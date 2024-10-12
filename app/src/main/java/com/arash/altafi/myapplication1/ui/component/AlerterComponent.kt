package com.arash.altafi.myapplication1.ui.component

import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arash.altafi.myapplication1.R
import com.tapadoo.alerter.Alerter

@Composable
fun AlerterComponent(
    showAlert: Boolean,
    onDismiss: () -> Unit
) {
    Alerter(
        isShown = showAlert,
        onChanged = {
            onDismiss()
        },
        backgroundColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF9499FF), shape = RoundedCornerShape(18.dp))
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.gift_icon), contentDescription = "",
                tint = Color.Unspecified, modifier = Modifier
                    .padding(start = 24.dp)
                    .size(48.dp)
            )

            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text(text = "Gift", color = Color.White, fontWeight = FontWeight.SemiBold)
                Text(text = "Claim your gift!", color = Color.White, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    onDismiss()
                },
                shape = RoundedCornerShape(8.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4C52C7), contentColor = Color.White
                ),
                modifier = Modifier.padding(end = 24.dp)
            ) {
                Text(text = "Claim")
            }
        }
    }
}