package com.ingrid.livecodingtrival.presentation.categories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.domain.model.DetailCategorie
import com.ingrid.livecodingtrival.domain.useCase.GetCategorieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategorieDetailViewModel @Inject constructor(
    val categorieDetailUseCase: GetCategorieDetailUseCase
) : ViewModel() {

     private val _detailCategorie = MutableStateFlow(DetailUI())
    val detailCategorieUI = _detailCategorie.asStateFlow()

    fun getDetailCategorie(categorie: String) {
        viewModelScope.launch {
            _detailCategorie.update {
                it.copy(loading = true)
            }
            when(val rta = categorieDetailUseCase.invoke(categorie)) {
                is Result.Success -> {
                    _detailCategorie.update { it.copy(loading = false, detailCat = rta.data) }
                }
                is Result.Error -> {
                    _detailCategorie.update { it.copy(loading = false, error = rta.message) }
                }
            }
        }
    }



}

data class DetailUI(
    val loading: Boolean = false,
    val error : String? = null,
    val detailCat : DetailCategorie = DetailCategorie()
)