package com.ingrid.livecodingtrival

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ingrid.livecodingtrival.presentation.categories.navigation.NavGraph
import com.ingrid.livecodingtrival.ui.theme.LiveCodingTrivalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LiveCodingTrivalTheme {
                ScaffoldApp()

            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavGraph(navHostController = navController, modifier = Modifier.padding(innerPadding) )
    }
}