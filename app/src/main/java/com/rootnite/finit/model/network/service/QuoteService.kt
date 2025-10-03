package com.rootnite.finit.model.network.service

import com.rootnite.finit.model.local.database.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getAllQuotes()
                response.body() ?: emptyList()
            } catch (e: Exception) {
                e.printStackTrace()
                emptyList()
            }
        }
    }

}