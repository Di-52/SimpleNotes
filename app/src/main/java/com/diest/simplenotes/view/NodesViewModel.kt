package com.diest.simplenotes.view

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.diest.simplenotes.R
import com.diest.simplenotes.Repositories
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NodesViewModel(application: Application) : AndroidViewModel(application) {

    private val rep: NoteRepository
    private var allNotes: LiveData<List<NoteModel>>
    private val logTag: String =  application.resources.getString(R.string.app_name)

    init {
        rep = Repositories.getNoteRepository()
        allNotes = rep.getAllNotes()

    }

    fun getAllNote(): LiveData<List<NoteModel>>{
        return allNotes
    }

    fun addNote(title: String, text: String?){
        viewModelScope.launch(Dispatchers.IO){
            rep.addNote(NoteModel(null,title, text))
            Log.d(logTag ,"Add Note [ Title: ${title}, Text: ${text} ]")
        }
    }

    fun removeNote(note: NoteModel){
        viewModelScope.launch(Dispatchers.IO){
            rep.deleteNote(note)
            Log.d(logTag,"Delete Note [ Id: ${note.id}, Title: ${note.title}, Text: ${note.text} ]")
        }
    }
}