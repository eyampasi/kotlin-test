package com.rootnite.finit.model.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rootnite.finit.model.local.database.dao.QuoteDao
import com.rootnite.finit.model.local.database.entity.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}