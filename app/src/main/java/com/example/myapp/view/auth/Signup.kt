package com.example.myapp.view.auth

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.Resource
import com.example.myapp.navigation.HomeNav.ROUTE_HOME
import com.example.myapp.navigation.AppNav.ROUTE_LOGIN
import com.example.myapp.navigation.AppNav.ROUTE_SIGNUP
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.viewModel.AuthViewModel

@Composable
fun SignupScreen(
    viewModel : AuthViewModel?,
    navController : NavHostController,
) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val signupFlow = viewModel?.signupFlow?.collectAsState()

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = { focusManager.clearFocus() })
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = name,
                onValueChange = {
                    name = it
                },
                label = {
                    Text(text = "name")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(text = "email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = "password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    focusManager.clearFocus()
                    viewModel?.signup(name, email, password)
                },
                modifier = Modifier.width(300.dp)
            ) {
                Text(
                    text = "sign up",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier
                    .clickable {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
                        }
                    },
                text = "Already have an account?\nClick here to login",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            signupFlow?.value?.let {
                when (it) {
                    is Resource.Failure -> {
                        val context = LocalContext.current
                        LaunchedEffect(Unit) {
                            Toast.makeText(context, it.exception.message, Toast.LENGTH_LONG).show()
                        }
                    }

                    is Resource.Loading -> {
                        CircularProgressIndicator(modifier = Modifier.size(30.dp))
                    }

                    is Resource.Success -> {
                        LaunchedEffect(Unit) {
                            navController.navigate(ROUTE_HOME) {
                                popUpTo(ROUTE_SIGNUP) { inclusive = true }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewSignupScreenLight() {
    MyAppTheme {
        SignupScreen(null, navController = rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSignupScreenDark() {
    MyAppTheme {
        SignupScreen(null, navController = rememberNavController())
    }
}