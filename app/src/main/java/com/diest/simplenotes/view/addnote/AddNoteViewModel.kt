package com.diest.simplenotes.view.addnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diest.simplenotes.Repositories
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.entity.NoteModel

class AddNoteViewModel: ViewModel() {

    private val rep: NoteRepository = Repositories.repository

    private val notes: MutableLiveData<List<NoteModel>> by lazy {
        MutableLiveData<List<NoteModel>>().also {
            loadNotes()
        }
    }

    fun getNotes(): LiveData<List<NoteModel>> {
        return notes
    }

    private fun loadNotes() {
        var list = rep.getAllNotes()
        if (list.size == 0){
            list = listOf(NoteModel("title1", "text1"),NoteModel("title2", "text2"))
        }
        notes.value = list
    }

    fun addNote(note: NoteModel){
        rep.updateNote(note)
    }
}