package com.ingrid.livecodingtrival.domain.useCase

import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.domain.model.DetailCategorie
import com.ingrid.livecodingtrival.domain.repository.CategorieDetailRepository
import javax.inject.Inject

class GetCategorieDetailUseCase @Inject constructor(val categorieDetailRepository: CategorieDetailRepository) {
    suspend operator fun invoke(categorie: String): Result<DetailCategorie> {
        return categorieDetailRepository.getDetailCategorie(categorie)
    }
}
