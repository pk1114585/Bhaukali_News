package com.pk.bhaukalinews.model

import com.pk.bhaukalinews.model.Article

data class NewsResponce(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)