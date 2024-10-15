package com.example.healthwise.repository

import android.util.Log
import com.example.healthwise.api.DiseaseApi
import com.example.healthwise.models.Disease
import com.example.healthwise.models.DiseaseX
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


class DiseaseRepository @Inject constructor(private val diseaseApi: DiseaseApi) {

    private val _diseaseCategory = MutableStateFlow<List<String>>(emptyList())
    val diseaseCategory : StateFlow<List<String>>
        get() = _diseaseCategory

    private val _diseasesList = MutableStateFlow<List<DiseaseX>>(emptyList())
    val diseasesList : StateFlow<List<DiseaseX>>
        get() = _diseasesList

    suspend fun getCategories(){
        val response = diseaseApi.getDiseaseCategory()
        if(response.isSuccessful && response.body()!=null){
            _diseaseCategory.emit(response.body()!!)
        }
    }

    suspend fun getDiseases(category: String){
        Log.d("CATEGORYYYYYYYY", category.removePrefix("{").removeSuffix("}"))
        val response = diseaseApi.getDiseaseData("diseases[?(@.category=='${category.removePrefix("{").removeSuffix("}")}')].diseases[*]")
        if(response.isSuccessful && response.body()!=null){
            Log.d("DATAAAAATAAAAA", response.body()!!.toString())
            _diseasesList.emit(response.body()!!)
        }
    }
}