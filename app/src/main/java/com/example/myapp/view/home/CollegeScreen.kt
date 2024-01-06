package com.example.myapp.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.R
import com.example.myapp.data.Resource
import com.example.myapp.model.College
import com.example.myapp.model.Course
import com.example.myapp.view.components.CustomTopAppBar
import com.example.myapp.view.components.ErrorToastMessage
import com.example.myapp.viewModel.HomeViewModel

@Composable
fun CollegeScreen(
    homeViewModel : HomeViewModel?,
    navController : NavHostController,
) {
    val collegeData = homeViewModel?.collegeData?.collectAsState()
    collegeData?.value?.let {
        when (it) {
            is Resource.Failure -> {
                ErrorToastMessage(it)
            }

            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier.size(30.dp))
            }

            is Resource.Success -> {
                it.result.college?.let { items ->
                    CollegeList(
                        collegeData = items,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun CollegeList(
    collegeData : List<College>,
    navController : NavHostController,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopAppBar(title = "College Details") {
            navController.popBackStack()
        }
        if (collegeData.size == 1) {
            CollegeCard(
                image = R.drawable.college_icon,
                collegeItem = collegeData[0],
                onClick = {}
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(2.dp)
            ) {
                itemsIndexed(collegeData) { index, item ->
                    CollegeCard(
                        image = R.drawable.college_icon,
                        collegeItem = item,
                        onClick = {}
                    )
                }
            }
        }

    }
}

@Composable
fun CollegeCard(
    image : Int,
    collegeItem : College,
    onClick : (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .height(230.dp)
            .padding(12.dp)
            .background(shape = RoundedCornerShape(12.dp), color = Color.White)
            .clickable(onClick = { collegeItem.id?.let { onClick(it) } }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "card_icon",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(120.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = collegeItem.collegeName.orEmpty(),
                    fontSize = 12.sp,
                    color = Color.Black,
                    lineHeight = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = collegeItem.district.orEmpty(),
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCollegeList() {
    val courseDataOne = listOf(
        Course(
            admissionFee = "50,000",
            courseDuration = "4 year",
            courseId = "para-KABLR24010402-03",
            courseName = "Bsc Nursing",
            feesPer = "Year",
            finalYear = null,
            firstYear = "1,71,000",
            fourthYear = "1,61,000",
            secondYear = "1,61,000",
            stream = "Para medical",
            thirdYear = "1,61,000",
            totalFee = "16,00,0000"
        )
    )
    val collegeData = listOf(
        College(
            id = "KABLR24010402",
            collegeName = "BGS Group of Institution",
            state = "Karnataka",
            district = "Bangalore",
            country = "India",
            university = "Bangalore university",
            approvals = listOf("INC"),
            autonomous = false,
            deemed = false,
            courses = courseDataOne
        ),
        College(
            id = "KABLR24010403",
            collegeName = "PA College",
            state = "Karnataka",
            district = "Mangalore",
            country = "India",
            university = "Bangalore university",
            approvals = listOf("AICTE", "UGC"),
            autonomous = false,
            deemed = false,
            courses = courseDataOne
        ),
        College(
            id = "TNED24010404",
            collegeName = "Excel Engineering and technology in a model College",
            state = "Tamilnadu",
            district = "Erode",
            country = "India",
            university = "Anna university chennai",
            approvals = listOf("AICTE", "UGC"),
            autonomous = true,
            deemed = false,
            courses = courseDataOne
        ),
        College(
            id = "TNCBE24010405",
            collegeName = "RVS Nursing College",
            state = "Tamilnadu",
            district = "Coimbatore",
            country = "India",
            university = "MGR university",
            approvals = listOf("INC"),
            autonomous = false,
            deemed = true,
            courses = courseDataOne
        )
    )
    CollegeList(
        collegeData = collegeData,
        navController = rememberNavController()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCollegeCard() {
    val courseData = listOf(
        Course(
            admissionFee = "50,000",
            courseDuration = "4 year",
            courseId = "para-KABLR24010402-03",
            courseName = "Bsc Nursing",
            feesPer = "Year",
            finalYear = null,
            firstYear = "1,71,000",
            fourthYear = "1,61,000",
            secondYear = "1,61,000",
            stream = "Para medical",
            thirdYear = "1,61,000",
            totalFee = "16,00,0000"
        )
    )
    val collegeData = College(
        id = "KABLR24010402",
        collegeName = "BGS Group of Institution",
        state = "Karnataka",
        district = "Bangalore",
        country = "India",
        university = "Bangalore university",
        approvals = listOf("INC"),
        autonomous = false,
        deemed = false,
        courses = courseData
    )
    CollegeCard(
        image = R.drawable.college_icon,
        collegeItem = collegeData,
        onClick = {}
    )
}