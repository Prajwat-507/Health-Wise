package com.example.healthwise.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthwise.viewmodels.CategoryViewModel



@Composable
fun CategoryScreen(onCLick: (category: String)-> Unit){
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val category: State<List<String>> = categoryViewModel.diseaseCategory.collectAsState()

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.SpaceAround,
    ){
        items(category.value){
            CategoryItem(category = it, onCLick)
        }
    }
}



@Composable
fun CategoryItem(category: String, onCLick: (category: String) -> Unit){

    Box(modifier = Modifier
        .padding(4.dp)
        .size(130.dp, 130.dp)
        .background(Color(0xEEE9CBE6), shape = RectangleShape)
        .clickable {
            onCLick(category)
        }
        .clip(RoundedCornerShape(4.dp))
        .border(1.dp, Color(0xCB0F0F0F)),
        ){
        Text(text = category,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(4.dp, 6.dp)
                .align(Alignment.BottomCenter),
            style = MaterialTheme.typography.titleLarge,
        )
    }
}