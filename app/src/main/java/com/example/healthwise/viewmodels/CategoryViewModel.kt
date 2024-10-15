package com.example.healthwise.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthwise.repository.DiseaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// View Model's helps to save current instance of UI data, It maintains the original state of data when config changes


@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: DiseaseRepository): ViewModel() {

    val diseaseCategory : StateFlow<List<String>>
        get() = repository.diseaseCategory


    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }

}