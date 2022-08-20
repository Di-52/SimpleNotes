package com.diest.simplenotes.model.note

import androidx.lifecycle.LiveData
import com.diest.simplenotes.model.note.entity.NoteModel

interface NoteRepository {

    fun getAllNotes(): LiveData<List<NoteModel>>

    suspend fun addNote(note: NoteModel)

    suspend fun updateNote(note: NoteModel)

    suspend fun deleteNote(note: NoteModel)

}