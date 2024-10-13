package com.arash.altafi.myapplication1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arash.altafi.myapplication1.R
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme

@Composable
fun Test() {
    val context = LocalContext.current
    var count1 by remember { mutableIntStateOf(0) }
    var count2 by rememberSaveable { mutableIntStateOf(0) }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red)
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp),
                    onClick = {}
                ) {
                    Text("RoundedCornerShape")
                }

                Button(
                    shape = CutCornerShape(topEnd = 20.dp),
                    onClick = {}
                ) {
                    Text("CutCornerShape")
                }

                Button(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally),
                    shape = CircleShape,
                    onClick = {
                        count1++
                        count2++
                    }
                ) {
                    Text(
                        text = "Circle Shape",
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Count1: $count1",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    letterSpacing = 2.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "Count2: $count2",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily(Font(R.font.font_family)),
                    letterSpacing = 2.sp,
                    textDecoration = TextDecoration.LineThrough,
                )

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(R.string.lorem),
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    letterSpacing = 2.sp,
                    lineHeight = 20.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                Button(
                    modifier = Modifier
                        .padding(top = 20.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 20.dp,
                        disabledElevation = 0.dp,
                        hoveredElevation = 20.dp,
                        focusedElevation = 20.dp,
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF9499FF),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(1.dp, color = Color.Yellow),
                    onClick = {}
                ) {
                    Text(
                        text = "Custom Button",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                    )
                }

                TextField(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(280.dp),
                    value = email,
                    onValueChange = { newValue ->
                        email = newValue
                    },
                    label = {
                        Text(text = "Email")
                    },
                    placeholder = {
                        Text(text = "arash@gmail.com")
                    },
                    singleLine = true,
                    enabled = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Email,
                            contentDescription = "Email",
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next,
                        platformImeOptions = PlatformImeOptions("Done"),
                        autoCorrectEnabled = false,
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            Toast.makeText(context, "email: $email", Toast.LENGTH_SHORT).show()
                            email = ""
                            focusManager.moveFocus(FocusDirection.Next)
                        }
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(280.dp),
                    value = password,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    label = {
                        Text(text = "Password", color = Color.White)
                    },
                    placeholder = {
                        Text(text = "1234", color = Color.White)
                    },
                    singleLine = true,
                    enabled = true,
                    visualTransformation = PasswordVisualTransformation(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            contentDescription = "Password",
                            tint = Color.White
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done,
                        platformImeOptions = PlatformImeOptions("Done"),
                        autoCorrectEnabled = false,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            Toast.makeText(context, "password: $password", Toast.LENGTH_SHORT).show()
                            password = ""
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun TestPreview() {
    Test()
}