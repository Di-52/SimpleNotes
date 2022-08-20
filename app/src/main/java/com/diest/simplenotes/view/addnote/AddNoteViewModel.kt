package com.diest.simplenotes.view.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diest.simplenotes.Repositories
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    private val rep = Repositories.getNoteRepository()

    fun addNote(title: String, text: String?){
        viewModelScope.launch(Dispatchers.IO){
            rep.addNote(NoteModel(null, title, text))
        }
    }
}