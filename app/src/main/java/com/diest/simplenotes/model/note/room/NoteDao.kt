package com.diest.simplenotes.model.note.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.diest.simplenotes.model.note.entity.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNote(note: NoteModel)
}