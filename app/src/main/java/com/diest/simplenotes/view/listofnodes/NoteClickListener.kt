package com.diest.simplenotes.view.listofnodes

import com.diest.simplenotes.model.note.entity.NoteModel

interface NoteClickListener {
    fun onClick(note: NoteModel)
    fun onLongClick(note: NoteModel): Boolean
    fun onClickEdit(note: NoteModel)
}