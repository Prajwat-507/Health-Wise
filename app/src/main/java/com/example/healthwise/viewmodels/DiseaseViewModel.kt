package com.example.healthwise.viewmodels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.healthwise.models.Disease
import com.example.healthwise.models.DiseaseX
import com.example.healthwise.repository.DiseaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiseaseViewModel @Inject constructor(private val repository: DiseaseRepository,
    private val savedState: SavedStateHandle): ViewModel() {

    val diseaseList : StateFlow<List<DiseaseX>>
        get() = repository.diseasesList

    init {
        viewModelScope.launch {
            Log.d("SAVEDSTATEEEEE", savedState.get<String>("diseaseCategory").toString())
            val category = savedState.get<String>("diseaseCategory")?: "Cardiovascular System"
            repository.getDiseases(category)
        }
    }
}