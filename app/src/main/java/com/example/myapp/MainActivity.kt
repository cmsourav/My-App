package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myapp.navigation.AppNav
import com.example.myapp.navigation.appNavGraph
import com.example.myapp.navigation.homeNavGraph
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.viewModel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyAppTheme {
                NavHost(navController = navController, startDestination = AppNav.APP_ROUTE) {
                    appNavGraph(viewModel = viewModel, navController = navController)
                    homeNavGraph(viewModel = viewModel, navController = navController)
                }
            }
        }
    }
}