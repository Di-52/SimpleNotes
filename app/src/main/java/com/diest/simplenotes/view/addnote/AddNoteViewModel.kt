package com.diest.simplenotes.view.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diest.simplenotes.model.note.entity.NoteModel

class AddNoteViewModel: ViewModel() {

    private val notes: MutableLiveData<List<NoteModel>> by lazy {
        MutableLiveData<List<NoteModel>>().also {
            loadNotes()
        }
    }

    fun getNotes(): LiveData<List<NoteModel>> {
        return notes
    }

    private fun loadNotes() {
        TODO("implement fun to load notes from repository")
    }

    fun addNote(note: NoteModel){
        TODO("implement method to add new note")
    }
}