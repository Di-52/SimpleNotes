package com.diest.simplenotes.model.note.room

import androidx.lifecycle.LiveData
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel
import kotlinx.coroutines.CoroutineDispatcher

class RoomNoteRepository(private val dao: NoteDao): NoteRepository {

    override fun getAllNotes(): LiveData<List<NoteModel>> {
        return dao.getAllNotes()
    }

    override suspend fun addNote(note: NoteModel) {
        dao.addNote(note)
    }

    override suspend fun updateNote(note: NoteModel) {
        dao.updateNote(note)
    }

    override suspend fun deleteNote(note: NoteModel) {
        dao.deleteNote(note)
    }
}