package com.ingrid.livecodingtrival.data.remote.api

import com.ingrid.livecodingtrival.data.models.DetailCategorieDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategorieDetailApi {
    @GET("jokes/random")
    suspend fun getDetail(
        @Query("categorie") categorie : String
    ) : Response<DetailCategorieDTO>

}