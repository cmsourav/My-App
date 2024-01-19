package com.example.myapp.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val Int.NormalStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = this.sp
    )

val Int.MediumStyle
    get() = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = this.sp
    )

val Int.BoldStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = this.sp
    )

val Int.ExtraBold
    get() = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = this.sp
    )

val Int.NormalLineThroughStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = this.sp,
        textDecoration = TextDecoration.LineThrough
    )

@Composable
fun Int.HorizontalSpace() {
    Spacer(modifier = Modifier.width(this.dp))
}

@Composable
fun Int.VerticalSpace() {
    Spacer(modifier = Modifier.height(this.dp))
}