package com.diest.simplenotes

import android.app.Application
import android.content.Context
import androidx.room.RoomDatabase
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.room.NoteRoomDatabase
import com.diest.simplenotes.model.note.room.RoomNoteRepository
import com.diest.simplenotes.model.note.shared.SharedPreferencesNoteRepository

object Repositories {

    private lateinit var appContex: Context

    val sharedPreferencesNoteRepository: NoteRepository by lazy {
        SharedPreferencesNoteRepository(appContex)
    }

    val roomNoteRepository: NoteRepository by lazy {
        RoomNoteRepository(NoteRoomDatabase.getDatabase(appContex).getDao())
    }

    fun init(context: Context) {
        appContex = context
    }

    fun getNoteRepository(): NoteRepository {
        return roomNoteRepository
        //return sharedPreferencesNoteRepository
    }
}