package com.ingrid.livecodingtrival.presentation.categories.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ingrid.livecodingtrival.presentation.categories.ui.CategoriesScreen

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navHostController,
        startDestination = CategoriesRoute,
        modifier = modifier
    ) {
        composable<CategoriesRoute> {
            CategoriesScreen(modifier = modifier)
        }
    }
}
