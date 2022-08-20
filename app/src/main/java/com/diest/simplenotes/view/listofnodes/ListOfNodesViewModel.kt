package com.diest.simplenotes.view.listofnodes

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.diest.simplenotes.R
import com.diest.simplenotes.Repositories
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListOfNodesViewModel(application: Application) : AndroidViewModel(application) {

    private val rep: NoteRepository
    private var allNotes: LiveData<List<NoteModel>>

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
        }
    }

    fun removeNote(note: NoteModel){
        viewModelScope.launch(Dispatchers.IO){
            rep.deleteNote(note)
            
        }
    }
}