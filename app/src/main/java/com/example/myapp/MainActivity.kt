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
import com.example.myapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val authViewModel by viewModels<AuthViewModel>()
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyAppTheme {
                NavHost(navController = navController, startDestination = AppNav.APP_ROUTE) {
                    appNavGraph(viewModel = authViewModel, navController = navController)
                    homeNavGraph(authViewModel = authViewModel, homeViewModel= homeViewModel, navController = navController)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        homeViewModel.getDataFromRepo()
    }
}