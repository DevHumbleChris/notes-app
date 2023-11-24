package com.montana.inc.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import de.charlex.compose.RevealDirection
import de.charlex.compose.RevealSwipe
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Home(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel,
    onNoteClicked: (UUID) -> Unit,
) {
    val state = viewModel.currentState.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Notes", fontSize = 30.sp)
                },
                actions = {
                    Button(
                        onClick = {
                            navHostController.navigate("SearchScreen")
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#3B3B3B",
                                ),
                            ),
                        ),
                        shape = RoundedCornerShape(percent = 30),
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp),
                        )
                    }
                    Spacer(modifier = modifier.width(10.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(
                                android.graphics.Color.parseColor(
                                    "#3B3B3B",
                                ),
                            ),
                        ),
                        shape = RoundedCornerShape(percent = 30),
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp),
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(android.graphics.Color.parseColor("#252525")),
                    titleContentColor = Color.White,
                ),
                modifier = modifier.padding(6.dp),
            )
        },
        containerColor = Color(android.graphics.Color.parseColor("#252525")),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("EditorScreen")
                },
                modifier = modifier.offset(x = 3.dp, y = (-20).dp),
            ) {
                Icon(Icons.Filled.Add, "Floating action button.")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
        ) {
            if (state.notes.isNotEmpty()) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    modifier = modifier.padding(18.dp),
                ) {
                    items(state.notes) { note ->
                        RevealSwipe(
                            modifier = Modifier.padding(vertical = 5.dp),
                            directions = setOf(
                                RevealDirection.StartToEnd,
                                RevealDirection.EndToStart,
                            ),
                            hiddenContentStart = {
                                Icon(
                                    modifier = Modifier.padding(horizontal = 25.dp),
                                    imageVector = Icons.Outlined.Star,
                                    contentDescription = null,
                                    tint = Color.White,
                                )
                            },
                            hiddenContentEnd = {
                                IconButton(onClick = {
                                    viewModel.deleteNote(note)
                                }) {
                                    Icon(
                                        modifier = Modifier
                                            .padding(horizontal = 25.dp),
                                        imageVector = Icons.Outlined.Delete,
                                        contentDescription = null,
                                    )
                                }
                            },
                        ) {
                            AddNote(
                                uuid = note.uuid,
                                title = note.title,
                                modifier = Modifier.clickable {
                                    onNoteClicked.invoke(note.uuid)
                                },

                            )
                        }
                    }
                }
            } else {
                Column(
                    modifier = modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rafiki),
                        contentDescription = "Create your first note",
                        modifier = modifier.requiredSize(250.dp),
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Text(text = "Create your first note", color = Color.White, fontSize = 20.sp)
                }
            }
        }
    }
}
