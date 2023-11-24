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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel,
) {
    val state = viewModel.currentState.collectAsState().value
    var isSearching by remember {
        mutableStateOf(false)
    }
    Scaffold(
        containerColor = Color(android.graphics.Color.parseColor("#252525")),
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
        ) {
            Column(
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxSize(),
            ) {
                OutlinedTextField(
                    value = viewModel.query,
                    onValueChange = {
                        viewModel.query = it
                        isSearching = true
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.extraLarge),
                    placeholder = {
                        Text(
                            text = "Search by the title...",
                            color = Color(android.graphics.Color.parseColor("#CCCCCC")),
                        )
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
                                tint = Color.White,
                            )
                        }
                    },
                    singleLine = true,
                )
                if (isSearching) {
                    if (state.searchResults.isNotEmpty()) {
                        LazyColumn(
                            modifier = modifier.padding(horizontal = 8.dp, vertical = 20.dp),
                        ) {
                            items(state.searchResults) { result ->
                                Column(
                                    modifier = modifier
                                        .fillMaxWidth()
                                        .background(
                                            Color(android.graphics.Color.parseColor("#91F48F")),
                                            shape = RoundedCornerShape(percent = 10),
                                        ),
                                ) {
                                    Text(
                                        text = result.title,
                                        color = Color.Black,
                                        modifier = Modifier.padding(20.dp),
                                        fontSize = 20.sp,
                                    )
                                }
                            }
                        }
                    } else {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = modifier.fillMaxSize(),
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cuate),
                                contentDescription = "Note not found image",
                                modifier = modifier.requiredSize(290.dp),
                            )
                            Text(
                                text = "Note not found. Try searching again.",
                                color = Color.White,
                                fontSize = 20.sp,
                                modifier = modifier.offset(y = (-35).dp),
                            )
                        }
                    }
                } else {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier.fillMaxSize(),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Start your search",
                            modifier = modifier.requiredSize(280.dp),
                        )
                        Text(
                            text = "Start your search on the searchbar.",
                            color = Color.White,
                            fontSize = 20.sp,
                        )
                    }
                }
            }
        }
    }
}
