package com.arash.altafi.myapplication1.ui.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.arash.altafi.myapplication1.R
import com.arash.altafi.myapplication1.ui.theme.MyApplication1Theme

@Composable
fun Test2() {
    val context = LocalContext.current
    var count1 by remember { mutableIntStateOf(0) }
    var count2 by rememberSaveable { mutableIntStateOf(0) }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val state = rememberScrollState()

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
                    .padding(innerPadding)
                    .verticalScroll(state),
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
                            Toast.makeText(context, "password: $password", Toast.LENGTH_SHORT)
                                .show()
                            password = ""
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    )
                )

                AsyncImage(
                    model = "https://arashaltafi.ir/Social_Media/story-04.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(250.dp)
                        .height(250.dp)
                        .clip(RoundedCornerShape(topEnd = 50.dp))
                        .shadow(10.dp)
                        .border(1.dp, Color.Blue, RoundedCornerShape(topEnd = 50.dp)),
                    contentScale = ContentScale.None,
                )

                AsyncImage(
                    model = "https://arashaltafi.ir/Social_Media/story-04.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(250.dp)
                        .height(250.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Click", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .clip(CircleShape)
                        .shadow(10.dp)
                        .border(1.dp, Color.Blue, CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Card(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .width(250.dp)
                        .height(250.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Click", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .shadow(10.dp, RoundedCornerShape(20.dp))
                        .shadow(2.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 20.dp,
                        focusedElevation = 20.dp,
                        hoveredElevation = 20.dp,
                        disabledElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Card",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun Test3() {
    val languages: List<String> = listOf(
        "Java",
        "Kotlin",
        "C++",
        "Python",
        "Swift",
        "JavaScript",
        "Rust",
        "Dart",
        "Go",
        "PHP",
        "Ruby",
        "C#",
        "C",
        "R",
    )

    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LazyRow(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(top = 8.dp)
                ) {
                    items(languages.size) {
                        RowItem(text = languages[it], false)
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    items(languages.size) {
                        RowItem(text = languages[it], true)
                    }
                }
            }
        }
    }
}

@Composable
fun Test4() {
    val context = LocalContext.current

    val names = arrayOf(
        "arash",
        "alireza",
        "mamad",
        "ali",
        "reza",
        "mohsen",
    )

    val images = arrayOf(
        "https://arashaltafi.ir/Social_Media/story-01.jpg",
        "https://arashaltafi.ir/Social_Media/story-02.jpg",
        "https://arashaltafi.ir/Social_Media/story-03.jpg",
        "https://arashaltafi.ir/Social_Media/story-04.jpg",
        "https://arashaltafi.ir/Social_Media/story-05.jpg",
        "https://arashaltafi.ir/Social_Media/story-016.jpg",
    )

    val sentences = arrayOf(
        "lorem ipsum dolor sit amet",
        "consectetur adipiscing elit",
        "sed do eiusmod tempor incididunt",
        "ut labore et dolore magna aliqua",
        "ut enim ad minim veniam",
        "quis nostrud exercitation ullamco laboris",
    )

    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = PaddingValues(16.dp)
            ) {
                items(names.size) {
                    Card(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 10.dp
                        ),
                        onClick = {
                            Toast.makeText(context, names[it], Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(15.dp)
                        ) {
                            AsyncImage(
                                model = images[it],
                                contentDescription = names[it],
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .shadow(10.dp)
                                    .background(Color.Red)
                                    .border(1.dp, Color.Blue, CircleShape),
                                contentScale = ContentScale.Crop,
                            )
                            Column(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = names[it],
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    text = sentences[it],
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun Test5() {
    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(12) {
                    RowItem("Item $it", true)
                }
            }
        }
    }
}

@Composable
fun Test() {
    val context = LocalContext.current
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    var checkBox by remember { mutableStateOf(false) }
    var switch by remember { mutableStateOf(false) }
    var radioButton by remember { mutableStateOf(false) }


    MyApplication1Theme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.teal_200),
                        contentColor = Color.White
                    ),
                    onClick = {
                        Toast.makeText(context, "FillButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Text("Fill Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Black)
                )

                Button(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    enabled = false,
                    onClick = {
                        Toast.makeText(context, "FillButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Text("Disable Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Black)
                )

                OutlinedButton(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    onClick = {
                        Toast.makeText(context, "OutlineButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Text("Outline Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Black)
                )

                ElevatedButton(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    onClick = {
                        Toast.makeText(context, "ElevatedButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = null
                    )
                    Text("Elevated Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Black)
                )

                FilledTonalButton(
                    modifier = Modifier
                        .padding(0.dp, 10.dp),
                    onClick = {
                        Toast.makeText(context, "FilledTonalButton", Toast.LENGTH_SHORT).show()
                    },
                ) {
                    Text("FilledTonal Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.Black)
                )


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
                            Toast.makeText(context, "password: $password", Toast.LENGTH_SHORT)
                                .show()
                            password = ""
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    )
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(5.dp)
                        .background(Color.Black)
                )


                RadioButton(
                    selected = radioButton,
                    onClick = {
                        radioButton = !radioButton
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(280.dp)
                )

                Checkbox(
                    checked = checkBox,
                    onCheckedChange = {
                        checkBox = it
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(280.dp)
                )


                Switch(
                    checked = switch,
                    onCheckedChange = {
                        switch = it
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .width(280.dp)
                )
            }
        }
    }
}

@Composable
fun RowItem(text: String, isColumn: Boolean) {
    val context = LocalContext.current

    val modifier = if (isColumn) {
        Modifier
            .fillMaxWidth()
            .padding(10.dp, 6.dp)
    } else {
        Modifier
            .padding(8.dp, 2.dp)
    }

    Card(
        modifier = modifier,
        onClick = {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
        },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 20.dp,
            focusedElevation = 20.dp,
            hoveredElevation = 20.dp,
            disabledElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(
                (0..255).random(),
                (0..255).random(),
                (0..255).random(),
            )
        )
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(18.dp, 12.dp)
        )
    }
}

@Preview
@Composable
fun TestPreview() {
    Test()
}