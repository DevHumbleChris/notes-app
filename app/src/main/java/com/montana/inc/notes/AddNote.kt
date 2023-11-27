package com.montana.inc.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.UUID

@Composable
fun AddNote(modifier: Modifier = Modifier, title: String, uuid: UUID) {
    // Define a list of specific colors
    val noteColors = listOf(
        Color(android.graphics.Color.parseColor("#FD99FF")), // Lavender
        Color(android.graphics.Color.parseColor("#FF9E9E")), // Light Coral
        Color(android.graphics.Color.parseColor("#91F48F")), // Mint Green
        Color(android.graphics.Color.parseColor("#FFF599")), // Pale Yellow
        Color(android.graphics.Color.parseColor("#9EFFFF")), // Light Cyan
        Color(android.graphics.Color.parseColor("#B69CFF")), // Light Purple
    )

    // Get or initialize the color based on the note's UUID
    val savedColor = remember(uuid) {
        mutableStateOf(noteColors.random())
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = savedColor.value,
                shape = RoundedCornerShape(percent = 10),
            ),
    ) {
        Text(
            text = title,
            color = Color.Black,
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp,
        )
    }
}

//This one changes randomly even on small configurationchnage:
//val noteColors = listOf(
//    Color(android.graphics.Color.parseColor("#FD99FF")), // Lavender
//    Color(android.graphics.Color.parseColor("#FF9E9E")), // Light Coral
//    Color(android.graphics.Color.parseColor("#91F48F")), // Mint Green
//    Color(android.graphics.Color.parseColor("#FFF599")), // Pale Yellow
//    Color(android.graphics.Color.parseColor("#9EFFFF")), // Light Cyan
//    Color(android.graphics.Color.parseColor("#B69CFF")), // Light Purple
//)
//
//// Get a random color from the list based on the note's UUID
//val randomColor = noteColors.random()