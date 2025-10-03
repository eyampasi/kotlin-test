package com.rootnite.finit.domain.model

import com.rootnite.finit.model.local.database.entity.QuoteEntity
import com.rootnite.finit.model.local.database.model.QuoteModel

data class Quote (val quote: String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)