package com.example.myapp.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.ui.theme.BoldStyle
import com.example.myapp.ui.theme.HorizontalSpace
import com.example.myapp.ui.theme.MediumStyle
import com.example.myapp.ui.theme.NormalStyle
import com.example.myapp.ui.theme.VerticalSpace
import com.example.myapp.view.components.CustomTopAppBar
import com.example.myapp.viewModel.HomeViewModel

@Composable
fun CollegeDetailScreen(
    navController : NavHostController,
    homeViewModel : HomeViewModel?,
) {
    val collegeItem = homeViewModel?.sharedCollegeData?.value
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(title = "College Details") {
            navController.popBackStack()
        }
        16.VerticalSpace()
        collegeItem?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.college_icon),
                            contentDescription = "college_bg",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                        )
                        12.VerticalSpace()
                        Text(
                            text = it.collegeName ?: "",
                            style = 18.MediumStyle,
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 4.dp)
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ItemKeyAndValue(key = "District", value = it.district ?: "")
                    ItemKeyAndValue(key = "State", value = it.state ?: "")
                    ItemKeyAndValue(key = "Country", value = it.country ?: "")
                    ItemKeyAndValue(key = "University", value = it.university ?: "")
                    ItemKeyAndValue(key = "About", value = it.about ?: "")
                    ItemKeyAndValue(key = "Established", value = it.established ?: "")
                    ItemKeyAndValue(key = "Courses", value = "")
                }
            }
        } ?: Text(text = "no data")
    }
}

@Composable
fun ItemKeyAndValue(
    key : String,
    value : String,
    modifier : Modifier = Modifier,
) {
    12.VerticalSpace()
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row {
            Text(
                text = key,
                style = 16.BoldStyle,
                color = Color.Black
            )
            4.HorizontalSpace()
            Text(
                text = ":",
                style = 16.BoldStyle,
                color = Color.Black
            )
        }
        8.HorizontalSpace()
        Text(
            text = value,
            style = 16.NormalStyle,
            color = Color.Black
        )
    }
}


@Preview
@Composable
fun PreviewCollegeDetailScreen() {
    CollegeDetailScreen(
        navController = rememberNavController(),
        homeViewModel = null,
    )
}