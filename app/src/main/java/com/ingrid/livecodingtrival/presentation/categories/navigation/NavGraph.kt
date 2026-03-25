package com.ingrid.livecodingtrival.presentation.categories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.ingrid.livecodingtrival.domain.model.DetailCategorie
import com.ingrid.livecodingtrival.presentation.categories.ui.CategoriesScreen
import com.ingrid.livecodingtrival.presentation.categories.ui.DetailCategorieScreen

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = CategoriesRoute,
        modifier = modifier
    ) {
        composable<CategoriesRoute> {
            CategoriesScreen(modifier = modifier, navToNextScreen = {
                navHostController.navigate(CategorieDetailRoute(categorie = it))
            })
        }
        composable<CategorieDetailRoute> { backStackEntry ->
            val detail = backStackEntry.toRoute<CategorieDetailRoute>()
            DetailCategorieScreen(categorie = detail.categorie, modifier = modifier)
        }
    }
}
