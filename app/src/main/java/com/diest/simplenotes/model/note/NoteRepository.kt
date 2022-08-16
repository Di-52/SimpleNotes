package com.diest.simplenotes.model.note

import com.diest.simplenotes.model.note.entity.NoteModel

interface NoteRepository {

    fun getAllNotes(): List<NoteModel>

    fun updateNote(note: NoteModel)

    fun deleteNote(note: NoteModel)

}