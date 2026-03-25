package com.ingrid.livecodingtrival.data.models

import com.ingrid.livecodingtrival.domain.model.DetailCategorie

fun DetailCategorieDTO.toDetailDomain() : DetailCategorie = DetailCategorie(
    value = this.value,
    url = this.url
)