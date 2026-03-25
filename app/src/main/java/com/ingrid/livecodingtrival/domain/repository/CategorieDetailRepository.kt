package com.ingrid.livecodingtrival.domain.repository

import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.domain.model.DetailCategorie

interface CategorieDetailRepository {
    suspend fun getDetailCategorie(categorie : String) : Result<DetailCategorie>
}