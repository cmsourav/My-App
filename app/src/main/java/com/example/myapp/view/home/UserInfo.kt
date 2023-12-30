package com.example.myapp.view.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapp.navigation.AppNav
import com.example.myapp.navigation.HomeNav
import com.example.myapp.view.components.CustomTextStyle
import com.example.myapp.viewModel.AuthViewModel

@Composable
fun UserInfo(
    viewModel : AuthViewModel?,
    navController : NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomTextStyle(
            text = "User Info",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                CustomTextStyle(
                    text = "name : " + "",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                CustomTextStyle(
                    text = viewModel?.currentUser?.displayName ?: "",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                CustomTextStyle(
                    text = "Email : " + "",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                CustomTextStyle(
                    text = viewModel?.currentUser?.email ?: "",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    viewModel?.logout()
                    navController.navigate(AppNav.ROUTE_LOGIN) {
                        popUpTo(HomeNav.ROUTE_HOME) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .width(190.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "log out")
            }
        }
    }
}