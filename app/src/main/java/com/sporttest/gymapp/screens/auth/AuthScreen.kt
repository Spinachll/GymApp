package com.sporttest.gymapp.screens.auth

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.R
import com.sporttest.gymapp.navigation.destinations.AuthDestinations
import com.sporttest.gymapp.screens.components.MainButton
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.ui.theme.PinkDark
import com.sporttest.gymapp.ui.theme.PlaceholderColor
import com.sporttest.gymapp.ui.theme.poppinsFamily
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun AuthScreen(
    rootNavController: NavHostController,
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    onClickLogin: (email: String, password: String, context: Context) -> Unit,
) {

    val currentContext = LocalContext.current

    val loginState = rememberSaveable {
        mutableStateOf<String?>(null)
    }

    val passwordState = rememberSaveable {
        mutableStateOf<String?>(null)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight(0.95f)
                .fillMaxWidth()
                .padding(top = 36.dp, start = 24.dp, end = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.3f)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(id = R.drawable.exercise_gym_svgrepo_com),
                contentDescription = "Main App Logo"
            )

            Text(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 25.dp)
                    .align(Alignment.CenterHorizontally),
                text = "Gym App",
                fontFamily = poppinsFamily,
                fontSize = 36.sp
            )

            TextInput(
                textState = loginState,
                placeholderText = "Login",
                leadingIcon = Icons.AutoMirrored.Filled.Login
            )

            TextInput(
                modifier = Modifier.padding(top = 20.dp),
                textState = passwordState,
                placeholderText = "Password",
                isPasswordField = true,
                leadingIcon = Icons.Default.Lock
            )

            Text(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        println("CLICKED")
                    },
                text = "Forgot your password?",
                fontFamily = poppinsFamily,
                textDecoration = TextDecoration.Underline,
                color = PlaceholderColor
            )

            MainButton(
                modifier = Modifier.padding(top = 20.dp),
                isLoading = loginViewModel.progressBar,
                text = "Login",
                onClick = {
                    if (loginState.value?.isBlank() == true) {
                        Toast.makeText(
                            currentContext, "Please, fill the login",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@MainButton
                    }

                    if (passwordState.value?.isBlank() == true) {
                        Toast.makeText(
                            currentContext, "Please, fill the password",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@MainButton
                    }

                    onClickLogin(loginState.value?:"", passwordState.value?:"", currentContext)
                },
                textColor = Color.White,
                gradient = BlueHorizontalGradient
            )

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                imageVector = ImageVector.vectorResource(R.drawable.two_mans),
                contentDescription = "Additional image",
                contentScale = ContentScale.Fit
            )

        }

        Text(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate(AuthDestinations.RegisterUser.route)
                    println("CLICKED")
                },
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                append("Don't have an account yet? ")

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = PinkDark
                    )
                ) {
                    append("Register")
                }
            },
            fontFamily = poppinsFamily,
        )
    }
}


//        Button(
//            onClick = {
//                //TODO move this to util file
//                onClickLogin("Test", "Test")
//
////            rootNavController.popBackStack(Graph.ROOT, true)
////            Graph.MAIN.let {
////                rootNavController.navigate(Graph.MAIN)
////            }
//            }
//        ) {
//            Text(text = "Go to home")
//        }