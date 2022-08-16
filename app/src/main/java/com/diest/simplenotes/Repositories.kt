package com.diest.simplenotes

import android.app.Application
import android.content.Context
import com.diest.simplenotes.model.note.NoteRepository
import com.diest.simplenotes.model.note.shared.SharedPreferencesNoteRepository

object Repositories {

    private lateinit var appContex: Context

    val repository: NoteRepository by lazy {
        SharedPreferencesNoteRepository(appContex)
    }

    fun init(context: Context) {
        appContex = context
    }
}