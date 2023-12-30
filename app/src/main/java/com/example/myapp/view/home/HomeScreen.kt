package com.example.myapp.view.home

import android.content.res.Configuration
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.model.CategoryData
import com.example.myapp.navigation.HomeNav.ROUTE_HOME
import com.example.myapp.navigation.AppNav.ROUTE_LOGIN
import com.example.myapp.navigation.HomeNav.ROUTE_APPROVED_ADMISSION
import com.example.myapp.navigation.HomeNav.ROUTE_COLLEGE
import com.example.myapp.navigation.HomeNav.ROUTE_COURSE
import com.example.myapp.navigation.HomeNav.ROUTE_ON_HOLD
import com.example.myapp.navigation.HomeNav.ROUTE_PENDING
import com.example.myapp.navigation.HomeNav.ROUTE_REFERRAL_REPORT
import com.example.myapp.navigation.HomeNav.ROUTE_SETTINGS
import com.example.myapp.navigation.HomeNav.ROUTE_TOTAL_ADMISSION
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.view.components.CustomTextStyle
import com.example.myapp.view.components.HomeCategoryList
import com.example.myapp.view.components.HomeHeader
import com.example.myapp.viewModel.AuthViewModel

@Composable
fun HomeScreen(
    viewModel : AuthViewModel?,
    navController : NavHostController,
) {
    val categoryList = listOf(
        CategoryData(ROUTE_COLLEGE, "College", 62, R.drawable.college),
        CategoryData(ROUTE_COURSE, "Course", 278, R.drawable.course),
        CategoryData(ROUTE_TOTAL_ADMISSION, "Total Admission", 0, R.drawable.total_admission),
        CategoryData(ROUTE_PENDING, "Pending", 0, R.drawable.pending),
        CategoryData(ROUTE_APPROVED_ADMISSION, "Approved Admission", 0, R.drawable.approved),
        CategoryData(ROUTE_REFERRAL_REPORT, "Referral Report", 0, R.drawable.referal),
        CategoryData(ROUTE_ON_HOLD, "On Hold Seat", 0, R.drawable.on_hold),
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HomeHeader(
            user = viewModel?.currentUser?.displayName ?: "",
            onIconClick = { navController.navigate(ROUTE_SETTINGS) }
        )
        HomeCategoryList(
            categoryList = categoryList,
            onCategoryClick = { navController.navigate(it) }
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    MyAppTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    MyAppTheme {
        HomeScreen(null, rememberNavController())
    }
}