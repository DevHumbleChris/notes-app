package com.montana.inc.notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NotesViewModel(): ViewModel() {
    private val _state = MutableStateFlow(NotesState())

    val currentState: StateFlow<NotesState> get() = _state.asStateFlow()

    fun setTitle(title: String) {
        _state.update { it.copy(
            title = title
        ) }
    }

    fun setDescription(description: String) {
        _state.update { it.copy(
            description = description
        ) }
    }

    fun addNotes() {
        val title = _state.value.title
        val description = _state.value.description

        _state.update { it.copy(
            title = "",
            description = "",
            notes = it.notes + Note(title = title, description = description)
        ) }
    }
}