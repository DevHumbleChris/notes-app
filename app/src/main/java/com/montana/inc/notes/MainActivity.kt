package com.montana.inc.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<NotesViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme(viewModel = viewModel)
        }
    }
}

@Preview
@Composable
fun NotesTheme(modifier: Modifier = Modifier, viewModel: NotesViewModel) {
    Navs(viewModel = viewModel)
}
