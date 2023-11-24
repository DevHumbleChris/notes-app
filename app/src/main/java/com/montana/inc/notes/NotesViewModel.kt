package com.montana.inc.notes

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.UUID

class NotesViewModel() : ViewModel() {
    private val _state = MutableStateFlow(NotesState())

    val currentState: StateFlow<NotesState> get() = _state.asStateFlow()
    private val _query = mutableStateOf("")

    var query: String
        get() = _query.value
        set(value) {
            _query.value = value
            setQueryResults()
        }

    private fun setQueryResults() {
        val resultsSearch = _state.value.notes.filter {
            it.title == _query.value
        }
        _state.update {
            it.copy(
                searchResults = resultsSearch,
            )
        }
    }

    fun setTitle(title: String) {
        _state.update {
            it.copy(
                title = title,
            )
        }
    }

    fun setDescription(description: String) {
        _state.update {
            it.copy(
                description = description,
            )
        }
    }
    fun deleteNote(note: Note) {
        _state.update { currentState ->
            currentState.copy(
                notes = currentState.notes - note
            )
        }
    }
    fun addNotes() {
        val title = _state.value.title
        val description = _state.value.description
        val uuid = UUID.randomUUID()

        _state.update {
            it.copy(
                notes = it.notes + Note(title = title, description = description, uuid = uuid),
                title = "",
                description = "",
            )
        }
    }
}
