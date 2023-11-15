package com.montana.inc.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditorScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel,
) {
    var showDialog by remember { mutableStateOf(false) }
    val state = viewModel.currentState.collectAsState().value

    Scaffold(
        containerColor = Color(android.graphics.Color.parseColor("#252525")),
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                navigationIcon = {
                    Button(
                        onClick = {
                            navHostController.navigate("Home")
                            viewModel.setTitle(title = "")
                            viewModel.setDescription(description = "")
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#3B3B3B"
                                )
                            )
                        ),
                        shape = RoundedCornerShape(percent = 30)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#252525")),
                    navigationIconContentColor = Color.White
                ),
                actions = {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#3B3B3B"
                                )
                            )
                        ),
                        shape = RoundedCornerShape(percent = 30)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.visibility),
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp)
                        )
                    }

                    Spacer(modifier = modifier.width(10.dp))

                    Button(
                        onClick = {
                            showDialog = true
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#3B3B3B"
                                )
                            )
                        ),
                        shape = RoundedCornerShape(percent = 30),
                        enabled = state.title.isNotBlank()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.save),
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp)
                        )
                    }
                },
                modifier = modifier.padding(6.dp)
            )
        }
    ) { innerPadding ->
        if (showDialog) {
            AlertDialog(
                icon = {
                    Icon(
                        imageVector = Icons.Rounded.Info,
                        contentDescription = "",
                        modifier = modifier.size(40.dp)
                    )
                },
                onDismissRequest = {
                    showDialog = false
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            viewModel.addNotes()
                            navHostController.navigate("Home")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#30BE71"
                                )
                            )
                        ),
                        shape = RoundedCornerShape(percent = 30)
                    ) {
                        Text("Save")
                    }
                },
                title = {
                    Text(text = "Save Changes!")
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog = false
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#FF0000"
                                )
                            )
                        ),
                        shape = RoundedCornerShape(percent = 30),
                    ) {
                        Text("Discard")
                    }
                },
                containerColor = Color(android.graphics.Color.parseColor("#C4C4C4"))
            )
        }

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.parseColor(("#252525"))))
                .padding(innerPadding)
        ) {

            OutlinedTextField(
                value = viewModel.currentState.collectAsState().value.title,
                onValueChange = { text ->
                    viewModel.setTitle(title = text)
                },
                placeholder = {
                    Text(
                        "Title",
                        fontSize = 30.sp,
                        color = Color(android.graphics.Color.parseColor("#9A9A9A"))
                    )
                },
                modifier = modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Color.White,
                    textColor = Color.White
                ),
                textStyle = TextStyle(
                    fontSize = 30.sp
                )
            )

            Spacer(modifier = modifier.height(10.dp))

            OutlinedTextField(
                value = viewModel.currentState.collectAsState().value.description,
                onValueChange = { text ->
                    viewModel.setDescription(description = text)
                },
                placeholder = {
                    Text(
                        "Type something...",
                        fontSize = 20.sp,
                        color = Color(android.graphics.Color.parseColor("#9A9A9A"))
                    )
                },
                modifier = modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = Color.White,
                    textColor = Color.White
                ),
                textStyle = TextStyle(
                    fontSize = 20.sp
                )
            )
        }
    }
}


//if (showDialog) {
//    AlertDialog(
//        icon = {
//            Icon(imageVector = Icons.Rounded.Info, contentDescription = "", modifier = modifier.size(40.dp))
//        },
//        onDismissRequest = {
//            showDialog = false
//        },
//        confirmButton = {
//            Button(
//                onClick = {
//                    showDialog = false
//                    viewModel.addNotes()
//                    navHostController.navigate("Home")
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#30BE71"))),
//                shape = RoundedCornerShape(percent = 30)
//            ) {
//                Text("Save")
//            }
//        },
//        title = {
//            Text(text = "Save Changes!")
//        },
//        dismissButton = {
//            Button(
//                onClick = {
//                    showDialog = false
//                },
//                colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#FF0000"))),
//                shape = RoundedCornerShape(percent = 30),
//            ) {
//                Text("Discard")
//            }
//        },
//        containerColor = Color(android.graphics.Color.parseColor("#C4C4C4"))
//    )
//}
//
//Column(
//modifier = modifier
//.fillMaxSize()
//.background(Color(android.graphics.Color.parseColor(("#252525"))))
//.padding(15.dp)
//) {
//    Row(
//        modifier = modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Button(
//            onClick = {
//                navHostController.navigate("Home")
//                viewModel.setTitle(title = "")
//                viewModel.setDescription(description = "")
//            },
//            modifier = Modifier
//                .height(50.dp)
//                .width(50.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#3B3B3B"))),
//            shape = RoundedCornerShape(percent = 30)
//        ) {
//            Icon(
//                imageVector = Icons.Rounded.ArrowBack,
//                contentDescription = "Search Icon",
//                tint = Color.White,
//                modifier = modifier.requiredSize(26.dp)
//            )
//        }
//
//        Row {
//
//        }
//    }
//
//    Spacer(modifier = modifier.height(30.dp))
//
//    OutlinedTextField(
//        value = viewModel.currentState.collectAsState().value.title,
//        onValueChange = { text ->
//            viewModel.setTitle(title = text)
//        },
//        placeholder = { Text("Title", fontSize = 30.sp, color = Color(android.graphics.Color.parseColor("#9A9A9A"))) },
//        modifier = modifier
//            .fillMaxWidth(),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Color.Transparent,
//            unfocusedBorderColor = Color.Transparent,
//            cursorColor = Color.White,
//            textColor = Color.White
//        ),
//        textStyle = TextStyle(
//            fontSize = 30.sp
//        )
//    )
//
//    Spacer(modifier = modifier.height(10.dp))
//
//    OutlinedTextField(
//        value = viewModel.currentState.collectAsState().value.description,
//        onValueChange = { text ->
//            viewModel.setDescription(description = text)
//        },
//        placeholder = { Text("Type something...", fontSize = 20.sp, color = Color(android.graphics.Color.parseColor("#9A9A9A"))) },
//        modifier = modifier
//            .fillMaxWidth(),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = Color.Transparent,
//            unfocusedBorderColor = Color.Transparent,
//            cursorColor = Color.White,
//            textColor = Color.White
//        ),
//        textStyle = TextStyle(
//            fontSize = 20.sp
//        )
//    )
//}