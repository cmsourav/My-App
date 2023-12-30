package com.example.myapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.R
import com.example.myapp.ui.theme.md_theme_light_onPrimaryContainer
import com.example.myapp.ui.theme.md_theme_light_secondary

@Composable
fun HomeHeader(
    user : String,
    onIconClick : () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column() {
            CustomTextStyle(
                text = "Welcome back",
                color = md_theme_light_onPrimaryContainer,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            CustomTextStyle(
                text = user,
                color = md_theme_light_secondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        IconButton(onClick = { onIconClick() }) {
            Image(
                painter = painterResource(id = R.drawable.icon_settings),
                contentDescription = "settings_icon",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun CustomTextStyle(
    text : String,
    modifier : Modifier = Modifier,
    style : TextStyle = TextStyle.Default,
    color : Color = Color.Unspecified,
    fontSize : TextUnit = TextUnit.Unspecified,
    fontWeight : FontWeight? = null,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style.copy(
            color = if (color != Color.Unspecified) color else style.color,
            fontSize = if (fontSize != TextUnit.Unspecified) fontSize else style.fontSize,
            fontWeight = fontWeight ?: style.fontWeight
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeHeader() {
    HomeHeader(
        user = "Sourav raj c m",
        onIconClick = {}
    )
}