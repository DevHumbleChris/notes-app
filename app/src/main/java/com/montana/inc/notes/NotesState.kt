package com.montana.inc.notes

data class NotesState(
    val notes: List<Note> = emptyList(),
    val title: String = "",
    val description: String = ""
)

data class Note(
    val title: String,
    val description: String
)