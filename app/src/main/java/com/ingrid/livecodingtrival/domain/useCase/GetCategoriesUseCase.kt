package com.ingrid.livecodingtrival.domain.useCase

import com.ingrid.livecodingtrival.domain.repository.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(val getRepository : CategoriesRepository) {
    suspend operator fun invoke() = getRepository.getCategories()
}
