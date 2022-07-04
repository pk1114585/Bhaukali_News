package com.pk.bhaukalinews.api

import com.pk.bhaukalinews.model.NewsResponce
import com.pk.bhaukalinews.util.Contants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countrycode: String="us",
        @Query("page")
        pagenumber: Int=1,
        @Query("apiKey")
        apiKey: String=Contants.API_KEY

    ): Response<NewsResponce>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        searchQuery: String,
        @Query("page")
        pagenumber: Int=1,
        @Query("apiKey")
        apiKey: String=Contants.API_KEY

    ): Response<NewsResponce>

}