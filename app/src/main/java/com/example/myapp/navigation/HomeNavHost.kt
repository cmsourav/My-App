package com.example.myapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.myapp.navigation.HomeNav.ROUTE_APPROVED_ADMISSION
import com.example.myapp.navigation.HomeNav.ROUTE_COLLEGE
import com.example.myapp.navigation.HomeNav.ROUTE_COURSE
import com.example.myapp.navigation.HomeNav.ROUTE_HOME
import com.example.myapp.navigation.HomeNav.ROUTE_ON_HOLD
import com.example.myapp.navigation.HomeNav.ROUTE_PENDING
import com.example.myapp.navigation.HomeNav.ROUTE_REFERRAL_REPORT
import com.example.myapp.navigation.HomeNav.ROUTE_SETTINGS
import com.example.myapp.navigation.HomeNav.ROUTE_TOTAL_ADMISSION
import com.example.myapp.view.home.ApprovedAdmissionScreen
import com.example.myapp.view.home.CollegeScreen
import com.example.myapp.view.home.CourseScreen
import com.example.myapp.view.home.HomeScreen
import com.example.myapp.view.home.OnHoldScreen
import com.example.myapp.view.home.PendingScreen
import com.example.myapp.view.home.ReferralReportScreen
import com.example.myapp.view.home.TotalAdmissionScreen
import com.example.myapp.view.home.UserInfo
import com.example.myapp.viewModel.AuthViewModel
import com.example.myapp.viewModel.HomeViewModel


fun NavGraphBuilder.homeNavGraph(
    authViewModel : AuthViewModel,
    homeViewModel : HomeViewModel,
    navController : NavHostController
) {
    navigation(startDestination = ROUTE_HOME, route = HomeNav.HOME_ROUTE) {
        composable(ROUTE_HOME) {
            HomeScreen(authViewModel, navController)
        }
        composable(ROUTE_COLLEGE) {
            CollegeScreen(homeViewModel = homeViewModel, navController = navController)
        }
        composable(ROUTE_COURSE) {
            CourseScreen()
        }
        composable(ROUTE_TOTAL_ADMISSION) {
            TotalAdmissionScreen()
        }
        composable(ROUTE_PENDING) {
            PendingScreen()
        }
        composable(ROUTE_APPROVED_ADMISSION) {
            ApprovedAdmissionScreen()
        }
        composable(ROUTE_REFERRAL_REPORT) {
            ReferralReportScreen()
        }
        composable(ROUTE_ON_HOLD) {
            OnHoldScreen()
        }
        composable(ROUTE_SETTINGS) {
            UserInfo(viewModel = authViewModel, navController = navController)
        }
    }
}