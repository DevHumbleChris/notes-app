package com.montana.inc.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Home(navHostController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor(("#252525"))))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Notes",
                    fontSize = 30.sp,
                    color = Color(android.graphics.Color.parseColor("#f1f1f1")))
                Row {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(android.graphics.Color.parseColor("#3B3B3B"))),
                        shape = RoundedCornerShape(percent = 50)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
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
                        shape = RoundedCornerShape(percent = 50)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "Search Icon",
                            tint = Color.White,
                            modifier = modifier.requiredSize(26.dp)
                        )
                    }
                }
            }

            Spacer(modifier = modifier.height(30.dp))
//            AddNote()
            Column (
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rafiki),
                    contentDescription = "Create your first note",
                    modifier = modifier.requiredSize(250.dp)
                )
                Spacer(modifier = modifier.height(5.dp))
                Text(text = "Create your first note", color = Color.White, fontSize = 20.sp)
            }
        }

        FloatingActionButton(
            onClick = {
                navHostController.navigate("EditorScreen")
            },
            modifier = modifier.align(alignment = Alignment.BottomEnd).offset(x = 3.dp, y = (-20).dp)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}
