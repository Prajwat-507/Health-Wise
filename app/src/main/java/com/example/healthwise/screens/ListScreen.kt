package com.example.healthwise.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthwise.models.Disease

import com.example.healthwise.models.DiseaseX
import com.example.healthwise.viewmodels.DiseaseViewModel


@Composable
fun DiseaseListView(){

    val diseaseViewModel: DiseaseViewModel = hiltViewModel()
    val diseaseList: State<List<DiseaseX>> = diseaseViewModel.diseaseList.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            items(diseaseList.value){
                DiseaseCard(diseaseX = it)
            }
        })
}


@Composable
fun DiseaseCard(diseaseX: DiseaseX) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xEEE9CBE6))
            .padding(vertical = 8.dp, horizontal = 4.dp),
        content = {
            Text(
                text = diseaseX.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 6.dp)
            )

            // Disease Description
            Text(
                text = diseaseX.description,
                fontSize = 14.sp,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 6.dp)
            )

            // Advice Title
            Text(
                text = "Advice:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp)
            )

            // Advice List
            diseaseX.advice.forEach { advice ->
                BasicText(text = "-> $advice")
            }
        }
    )
}