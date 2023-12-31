package com.montana.inc.notes

import java.util.UUID

data class NotesState(
    val notes: List<Note> = emptyList(),
    val title: String = "",
    val description: String = "",
    val editingNoteId: UUID? = null,
    val searchResults: List<Note> = emptyList(),
)

data class Note(
    val title: String,
    val description: String,
    val uuid: UUID,
)