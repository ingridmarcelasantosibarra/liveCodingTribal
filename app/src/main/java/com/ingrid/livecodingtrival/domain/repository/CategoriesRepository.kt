package com.ingrid.livecodingtrival.domain.repository

import com.ingrid.livecodingtrival.core.Result

interface CategoriesRepository {
    suspend fun getCategories() : Result<List<String>>
}