package com.example.healthwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.healthwise.screens.CategoryScreen
import com.example.healthwise.screens.DiseaseListView
import com.example.healthwise.ui.theme.HealthWiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HealthWiseTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "diseaseCategory"){
        composable(route = "diseaseCategory"){
            CategoryScreen{
                navController.navigate("diseaseList/{$it}")
            }
        }
        composable(route = "diseaseList/{diseaseCategory}",
            arguments = listOf(navArgument("diseaseCategory"){
                type = NavType.StringType
            })
        ){
            DiseaseListView()
        }
    }
}