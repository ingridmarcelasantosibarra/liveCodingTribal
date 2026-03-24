package com.ingrid.livecodingtrival.data.remote.api

import retrofit2.Response
import retrofit2.http.GET

interface JokesApi {
    @GET("jokes/categories")
    suspend fun getCategories() : Response<List<String>>
}