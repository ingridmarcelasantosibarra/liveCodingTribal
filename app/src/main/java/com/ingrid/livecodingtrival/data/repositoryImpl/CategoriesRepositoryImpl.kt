package com.ingrid.livecodingtrival.data.repositoryImpl

import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.data.remote.api.JokesApi
import com.ingrid.livecodingtrival.domain.repository.CategoriesRepository
import retrofit2.HttpException
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(val api: JokesApi) : CategoriesRepository {
    override suspend fun getCategories(): Result<List<String>> {
        return try {
            val callApi = api.getCategories()
            if (callApi.body() != null) {
                Result.Success(callApi.body()!!)
            } else {
                Result.Error("Mapper error body")
            }
        } catch (e: HttpException) {
            Result.Error(e.message() ?: "Unknown error")
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        } catch (e: InternalError) {
            Result.Error(e.message ?: "Unknown error")
        }
    }

}
