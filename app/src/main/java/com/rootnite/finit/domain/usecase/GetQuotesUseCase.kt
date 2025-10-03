package com.rootnite.finit.domain.usecase

import com.rootnite.finit.domain.model.Quote
import com.rootnite.finit.model.local.database.entity.toDatabase
import com.rootnite.finit.model.repository.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()
        return if (quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }
}