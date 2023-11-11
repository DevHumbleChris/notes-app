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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
fun EditorScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    var title by remember {
        mutableStateOf("")
    }

    var note by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier.fillMaxSize()
            .background(Color(android.graphics.Color.parseColor(("#252525"))))
            .padding(15.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navHostController.navigate("Home")
                },
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#3B3B3B"))),
                shape = RoundedCornerShape(percent = 30)
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Search Icon",
                    tint = Color.White,
                    modifier = modifier.requiredSize(26.dp)
                )
            }
            Row {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#3B3B3B"))),
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
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#3B3B3B"))),
                    shape = RoundedCornerShape(percent = 30)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.save),
                        contentDescription = "Search Icon",
                        tint = Color.White,
                        modifier = modifier.requiredSize(26.dp)
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(30.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { text ->
                title = text
            },
            placeholder = { Text("Title", fontSize = 30.sp, color = Color(android.graphics.Color.parseColor("#9A9A9A"))) },
            modifier = modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent, // Set the focused border color to transparent
                unfocusedBorderColor = Color.Transparent, // Set the unfocused border color to transparent
                cursorColor = Color.White, // Set the cursor color
                textColor = Color.White
            ),
            singleLine = true,
            textStyle = TextStyle(
                fontSize = 30.sp
            )
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = note,
            onValueChange = { text ->
                note = text
            },
            placeholder = { Text("Type something...", fontSize = 20.sp, color = Color(android.graphics.Color.parseColor("#9A9A9A"))) },
            modifier = modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent, // Set the focused border color to transparent
                unfocusedBorderColor = Color.Transparent, // Set the unfocused border color to transparent
                cursorColor = Color.White, // Set the cursor color,
                textColor = Color.White
            ),
            textStyle = TextStyle(
                fontSize = 20.sp
            ),

        )
    }
}
