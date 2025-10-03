package com.rootnite.finit.model.repository

import com.rootnite.finit.domain.model.Quote
import com.rootnite.finit.domain.model.toDomain
import com.rootnite.finit.model.local.database.dao.QuoteDao
import com.rootnite.finit.model.local.database.entity.QuoteEntity
import com.rootnite.finit.model.local.database.model.QuoteModel
import com.rootnite.finit.model.network.service.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}