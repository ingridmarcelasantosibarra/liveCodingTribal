package com.ingrid.livecodingtrival.presentation.categories.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ingrid.livecodingtrival.presentation.categories.viewmodel.CategoriesViewModel

@Composable
fun CategoriesScreen(modifier: Modifier, navToNextScreen: (String)-> Unit, viewModel : CategoriesViewModel = hiltViewModel())  {
    val state  by viewModel.categories.collectAsStateWithLifecycle()

    Column(modifier = modifier.fillMaxSize().padding(12.dp)) {
        when {
            state.loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.Center))
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

        state.categories.let { cat ->
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(cat.size) { index ->
                    Card(onClick = {
                        navToNextScreen(cat[index])
                    }) {
                        Text(text = cat[index])
                    }
                }
            }
        }
    }
}