package com.rootnite.finit.domain.usecase

import com.rootnite.finit.domain.model.Quote
import com.rootnite.finit.model.repository.QuoteRepository
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}