package com.diest.simplenotes.model.note.shared

import android.content.Context
import com.diest.simplenotes.model.note.NoteRepository

class SharedPreferencesNoteRepository(var context: Context): NoteRepository {

    override fun getAllNotes(): Map<String, String?> {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        var list = sp.all
        return list as Map<String, String?>
    }

    override fun updateNote(title: String, text: String) {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(title, text).apply()
    }

    override fun deleteNote(title: String) {
        val sp = context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.remove(title).apply()
    }
}