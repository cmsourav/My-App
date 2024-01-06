package com.example.myapp.view.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.example.myapp.data.Resource

@Composable
fun ErrorToastMessage(it : Resource.Failure) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
    }
}