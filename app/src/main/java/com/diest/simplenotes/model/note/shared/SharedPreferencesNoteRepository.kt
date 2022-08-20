package com.diest.simplenotes.model.note.shared

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel

class SharedPreferencesNoteRepository(var context: Context): NoteRepository {

    private val sp: SharedPreferences by lazy {
        context.getSharedPreferences("sharedPreferencesNotes",Context.MODE_PRIVATE)
    }
    private var allNotes: MutableList<NoteModel> = mutableListOf()

    override fun getAllNotes(): LiveData<List<NoteModel>> {
        return MutableLiveData(allNotes)
    }


    init {
        var list = sp.all
        for (item in list){
            if(item.key.contains("note_"))
                allNotes.add(NoteModel(null, item.key, item.value.toString()))
        }
    }

    /*
    override fun getAllNotes(): LiveData<List<NoteModel>> {
        var list = sp.all
        for (item in list){
            if(item.key.contains("note_"))
                m.add(NoteModel(item.key, item.value.toString()))
        }
        return MutableLiveData(m.toList())
    }*/


    override suspend fun addNote(note: NoteModel) {
        updateNote(note)
    }

    override suspend fun updateNote(note: NoteModel) {
        val editor = sp.edit()
        editor.putString("note_" + note.title, note.text).apply()
        allNotes.add(note)
    }

    override suspend fun deleteNote(note: NoteModel) {
        val editor = sp.edit()
        editor.remove(note.title).apply()
        allNotes.remove(note)
    }
}