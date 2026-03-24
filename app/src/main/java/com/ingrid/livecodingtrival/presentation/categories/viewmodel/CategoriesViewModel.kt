package com.ingrid.livecodingtrival.presentation.categories.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ingrid.livecodingtrival.core.Result
import com.ingrid.livecodingtrival.domain.useCase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class CategoriesViewModel @Inject constructor(private val getCategoriesUseCase: GetCategoriesUseCase) : ViewModel() {

    private val _categories = MutableStateFlow(CategoriesState())
    val categories = _categories.asStateFlow()

    init {
        getCategories()
    }
    fun getCategories() {
        viewModelScope.launch {
            _categories.update {
                it.copy(loading = true)
            }


            when (val result = getCategoriesUseCase()) {
                is Result.Success -> {
                    _categories.update {
                        it.copy(categories = result.data, loading = false)
                    }
                }

                is Result.Error -> _categories.update {
                    it.copy(error = result.message, loading = false)
                }

            }
        }
    }
}

data class CategoriesState(
    val loading: Boolean = false,
    val error: String? = null,
    val categories: List<String> = listOf()
)