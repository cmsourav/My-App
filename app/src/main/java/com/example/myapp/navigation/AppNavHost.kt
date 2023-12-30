package com.example.myapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapp.navigation.AppNav.APP_ROUTE
import com.example.myapp.navigation.AppNav.ROUTE_LOGIN
import com.example.myapp.navigation.AppNav.ROUTE_SIGNUP
import com.example.myapp.view.auth.LoginScreen
import com.example.myapp.view.auth.SignupScreen
import com.example.myapp.view.home.HomeScreen
import com.example.myapp.viewModel.AuthViewModel

fun NavGraphBuilder.appNavGraph(
    viewModel : AuthViewModel,
    navController : NavHostController,
) {
    navigation(startDestination = ROUTE_LOGIN, route = APP_ROUTE) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }
        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }
    }
}