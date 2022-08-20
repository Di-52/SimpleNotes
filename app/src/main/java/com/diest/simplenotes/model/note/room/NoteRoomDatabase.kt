package com.diest.simplenotes.model.note.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.diest.simplenotes.model.note.entity.NoteModel

@Database(
    entities = arrayOf(NoteModel::class), version = 1
)
abstract class NoteRoomDatabase: RoomDatabase() {
    abstract fun getDao(): NoteDao

    companion object{
        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        fun getDatabase(context: Context): NoteRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteRoomDatabase::class.java,
                    "note_database"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}