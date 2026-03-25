package com.ingrid.livecodingtrival.data.repositoryImpl

import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.data.models.toDetailDomain
import com.ingrid.livecodingtrival.data.remote.api.CategorieDetailApi
import com.ingrid.livecodingtrival.domain.model.DetailCategorie
import com.ingrid.livecodingtrival.domain.repository.CategorieDetailRepository
import javax.inject.Inject

class CategorieDetailRepositoryImpl @Inject constructor(val detailApi: CategorieDetailApi) :
    CategorieDetailRepository {
    override suspend fun getDetailCategorie(categorie: String): Result<DetailCategorie> {
        try {
            val data = detailApi.getDetail(categorie).body()
            if (data != null) {
                val response = data.toDetailDomain()
                return Result.Success(response)
            } else {
                return Result.Error("Error get info api")
            }
        } catch (e: Exception) {
            return Result.Error(e.message.toString())
        } catch (e: retrofit2.HttpException) {
            return Result.Error("${e.message}")
        }
    }
}