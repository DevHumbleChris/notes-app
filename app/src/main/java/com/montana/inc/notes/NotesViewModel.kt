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

    fun getNote(id: UUID?) {
        var note: Note? = null
        id?.let {
            currentState.value.notes.any {
                if (it.uuid == id) {
                    note = it
                }
                it.uuid == id
            }
            setTitle(note?.title ?: "")
            setDescription(note?.description ?: "")
            setEditingNoteId(id)
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

    fun setEditingNoteId(id: UUID?) {
        _state.update {
            it.copy(
                editingNoteId = id,
            )
        }
    }

    fun deleteNote(note: Note) {
        _state.update { currentState ->
            currentState.copy(
                notes = currentState.notes - note,
            )
        }
    }

    fun addNotes() {
        val title = _state.value.title
        val description = _state.value.description
        val editingNoteId = _state.value.editingNoteId

        _state.update { currentState ->
            val updatedNotes = currentState.notes.map { note ->
                if (note.uuid == editingNoteId) {
                    // Update the existing note if editingNoteId matches
                    note.copy(title = title, description = description)
                } else {
                    note
                }
            }

            if (editingNoteId == null || updatedNotes.none { it.uuid == editingNoteId }) {
                // If editingNoteId is null or doesn't match any existing notes, add a new note
                currentState.copy(
                    notes = currentState.notes + Note(title = title, description = description, uuid = UUID.randomUUID()),
                    title = "",
                    description = "",
                    editingNoteId = null,
                )
            } else {
                // If editingNoteId matches an existing note, return the updated state
                currentState.copy(
                    notes = updatedNotes,
                    title = "",
                    description = "",
                    editingNoteId = editingNoteId,
                )
            }
        }
    }
}
