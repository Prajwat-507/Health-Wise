package com.example.healthwise.api

import com.example.healthwise.models.Disease
import com.example.healthwise.models.DiseaseX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface DiseaseApi {

    @GET("/v3/b/66efe5f3ad19ca34f8aa9642?meta=false&")
    suspend fun getDiseaseData(@Header("X-JSON-Path") category: String) : Response<List<DiseaseX>>


    @GET("/v3/b/66efe5f3ad19ca34f8aa9642?meta=false&=")
    @Headers("X-JSON-Path:diseases..category")
    suspend fun getDiseaseCategory(): Response<List<String>>
}