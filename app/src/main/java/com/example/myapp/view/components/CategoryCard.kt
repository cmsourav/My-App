package com.example.myapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.model.CategoryData


@Composable
fun HomeCategoryList(
    categoryList : List<CategoryData>,
    onCategoryClick : (String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(12.dp)
    ) {
        itemsIndexed(categoryList) { index, item ->
            CategoryCard(
                title = item.title,
                count = item.count,
                image = item.image,
                onClick = { onCategoryClick(item.id) }
            )
        }
    }
}

@Composable
fun CategoryCard(
    title : String,
    count : Int,
    image : Int,
    onClick : () -> Unit,
    modifier : Modifier = Modifier,
    cardBG : Color = Color.White,
    fontColor : Color = Color.Black,
) {
    Card(
        modifier = modifier
            .padding(12.dp)
            .background(shape = RoundedCornerShape(12.dp), color = cardBG)
            .clickable(onClick = { onClick() }),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = cardBG)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = fontColor,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = count.toString(),
                fontSize = 16.sp,
                color = fontColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(6.dp))
            Image(
                painter = painterResource(id = image),
                contentDescription = "card_icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeCategoryList() {
    val categoryList = listOf(
        CategoryData("", "College", 62, R.drawable.college),
        CategoryData("", "Course", 278, R.drawable.course),
        CategoryData("", "Total Admission", 0, R.drawable.total_admission),
        CategoryData("", "Pending", 0, R.drawable.pending),
    )
    HomeCategoryList(
        categoryList = categoryList,
        onCategoryClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryCard() {
    CategoryCard(
        title = "College",
        count = 62,
        image = R.drawable.college,
        cardBG = Color.Yellow,
        onClick = {}
    )
}