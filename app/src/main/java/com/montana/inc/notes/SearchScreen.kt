package com.montana.inc.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Scaffold(
        containerColor = Color(android.graphics.Color.parseColor("#252525"))
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            Column(
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = modifier
                        .fillMaxWidth()
                        .offset(y = 20.dp)
                        .clip(MaterialTheme.shapes.extraLarge),
                    placeholder = {
                        Text(text = "Search by the title...", color = Color(android.graphics.Color.parseColor("#CCCCCC")))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color.White,
                        textColor = Color.White,
                        containerColor = Color(android.graphics.Color.parseColor("#3B3B3B")),
                    ),
                    shape = TextFieldDefaults.outlinedShape,
                    trailingIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Cancel",
                                tint = Color.White
                            )
                        }
                    },

                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cuate),
                        contentDescription = "File not found image",
                        modifier = modifier.requiredSize(290.dp)
                    )
                    Text(
                        text = "File not found. Try searching again.",
                        color = Color.White, fontSize = 20.sp,
                        modifier = modifier.offset(y = -35.dp)
                    )
                }
            }
        }
    }
}