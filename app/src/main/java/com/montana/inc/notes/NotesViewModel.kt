package com.montana.inc.notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

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
        val uuid = UUID.randomUUID()

        _state.update { it.copy(
            notes = it.notes + Note(title = title, description = description, uuid = uuid),
            title = "",
            description = "",
        ) }
    }
}