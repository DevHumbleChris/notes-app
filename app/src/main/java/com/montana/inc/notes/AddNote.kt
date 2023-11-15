package com.montana.inc.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.UUID


@Composable
fun AddNote(modifier: Modifier = Modifier, title: String, uuid: UUID) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(android.graphics.Color.parseColor("#91F48F")), shape = RoundedCornerShape(percent = 10)),
    ){
        Text(
            text = title,
            color = Color.Black,
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp
        )
    }
}