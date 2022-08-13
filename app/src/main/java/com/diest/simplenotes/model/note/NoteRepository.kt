package com.diest.simplenotes.model.note

interface NoteRepository {

    fun getAllNotes(): Map<String, String?>

    fun updateNote(title: String, text: String)

    fun deleteNote(title: String)

}