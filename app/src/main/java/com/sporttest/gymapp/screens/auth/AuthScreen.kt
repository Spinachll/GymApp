package com.sporttest.gymapp.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.R
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.ui.theme.poppinsFamily
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun AuthScreen(
    rootNavController: NavHostController,
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    onClickLogin: (email: String, password: String) -> Unit,
) {

    val loginState = rememberSaveable {
        mutableStateOf("")
    }

    val passwordState = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 24.dp, end = 24.dp)
    ) {
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

        Image(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.3f)
                .align(Alignment.CenterHorizontally),
            imageVector = ImageVector.vectorResource(id = R.drawable.exercise_gym_svgrepo_com),
            contentDescription = "Main App Logo"
        )

        Text(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 30.dp)
                .align(Alignment.CenterHorizontally),
            text = "Gym App",
            fontFamily = poppinsFamily,
            fontSize = 48.sp
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
            leadingIcon = Icons.Default.Lock
        )

    }
}