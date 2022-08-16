package com.diest.simplenotes.model.note.shared

import android.content.Context
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel

class SharedPreferencesNoteRepository(var context: Context): NoteRepository {

    override fun getAllNotes(): List<NoteModel> {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        var list = sp.all
        return list as List<NoteModel>
    }

    override fun updateNote(note: NoteModel) {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(note.title, note.text).apply()
    }

    override fun deleteNote(note: NoteModel) {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(note.title).apply()
    }
}