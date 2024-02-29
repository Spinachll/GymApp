package com.sporttest.gymapp.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sporttest.gymapp.R
import com.sporttest.gymapp.network.user.UserDto
import com.sporttest.gymapp.screens.components.MainButton
import com.sporttest.gymapp.screens.components.TextInput
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.ui.theme.PinkHorizontalGradient
import com.sporttest.gymapp.ui.theme.poppinsFamily
import com.sporttest.gymapp.viewmodel.LoginViewModel

@Composable
fun RegisterScreen(
    rootNavController: NavHostController,
    navController: NavHostController,
    loginViewModel: LoginViewModel
) {
    val localContext = LocalContext.current

    // Get local density from composable
    val localDensity = LocalDensity.current

    // Create element height in dp state
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(columnHeightDp)
                    .weight(2f)
                    .padding(0.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Please,\nintroduce\nyourself!",
                    fontFamily = poppinsFamily,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start,
                    letterSpacing = 1.sp,
                    lineHeight = 36.sp,
                    style = TextStyle(
                        brush = PinkHorizontalGradient
                    )
                )
            }

            Image(
                modifier = Modifier
                    //.fillMaxWidth()
                    .weight(3f)
                    .padding(top = 20.dp, bottom = 20.dp)
                    .onGloballyPositioned { coordinates ->
                        // Set column height using the LayoutCoordinates
                        columnHeightDp =
                            with(localDensity) { coordinates.size.height.toDp() + 40.dp }
                    },
                imageVector = ImageVector.vectorResource(R.drawable.one_man),
                contentDescription = "Additional image",
                contentScale = ContentScale.Fit
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CaptionText(text = "Login")
            TextInput(
                textState = loginViewModel.registerUser.value.login,
                leadingIcon = Icons.Default.TextFields,
                placeholderText = "Login"
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CaptionText(text = "Name")
            TextInput(
                textState = loginViewModel.registerUser.value.name,
                leadingIcon = Icons.Default.Person,
                placeholderText = "Name"
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            CaptionText(text = "Password")
            TextInput(
                textState = loginViewModel.registerUser.value.password,
                leadingIcon = Icons.Default.Password,
                placeholderText = "Password",
                isPasswordField = true
            )
        }

        MainButton(
            modifier = Modifier.padding(top = 12.dp),
            text = "Register",
            textColor = Color.White
        ) {
            loginViewModel.register(
                UserDto(
                    login = loginViewModel.registerUser.value.login.value,
                    name = loginViewModel.registerUser.value.login.value,
                    password = loginViewModel.registerUser.value.password.value
                ),
                localContext
            )
        }
    }

}

@Composable
fun CaptionText(
    text: String
) {
    Text(
        text = text,
        style = TextStyle(
            brush = BlueHorizontalGradient
        )
    )
}