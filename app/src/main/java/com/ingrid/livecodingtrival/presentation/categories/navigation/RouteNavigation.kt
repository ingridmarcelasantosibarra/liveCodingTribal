package com.ingrid.livecodingtrival.presentation.categories.navigation

import kotlinx.serialization.Serializable

@Serializable
data object CategoriesRoute

@Serializable
data class CategorieDetailRoute(val categorie: String)