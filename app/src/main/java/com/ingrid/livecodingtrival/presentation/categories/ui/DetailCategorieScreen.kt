package com.ingrid.livecodingtrival.presentation.categories.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ingrid.livecodingtrival.presentation.categories.viewmodel.CategorieDetailViewModel

@Composable
fun DetailCategorieScreen(categorie: String, modifier: Modifier, viewModel: CategorieDetailViewModel = hiltViewModel()) {

    LaunchedEffect(categorie) {
        viewModel.getDetailCategorie(categorie)
    }

    val state by viewModel.detailCategorieUI.collectAsStateWithLifecycle()

    Column(modifier = modifier) {
        when {
            state.loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            state.error != null -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Card(modifier = Modifier.align(alignment = Alignment.Center)) {
                        Text(
                            text = state.error!!,
                            color = Color.Red,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }

        if(state.detailCat.value.isNotEmpty()) {
            Box(modifier = Modifier.fillMaxSize()) {

                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "Value: ",
                                color = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = state.detailCat.value,
                                color = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth()) {

                            Text(
                                text = "url: ",
                                color = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                            Text(
                                text = state.detailCat.url,
                                color = Color.Black,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

            }
        }


    }
}