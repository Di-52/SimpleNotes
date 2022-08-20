package com.diest.simplenotes.model.note.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_text")
    val text: String?
)
