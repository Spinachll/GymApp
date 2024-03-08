package com.sporttest.gymapp.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Numbers
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.sporttest.gymapp.screens.components.NumberInput
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

    val roundedCornerShape = RoundedCornerShape(
        topStart = 14.dp,
        topEnd = 28.dp,
        bottomStart = 28.dp,
        bottomEnd = 14.dp
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.background(brush = PinkHorizontalGradient)
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        //TODO Change to intrinsicsize
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(columnHeightDp)
                    .weight(2f)
                    .shadow(6.dp, shape = roundedCornerShape)
                    .padding(0.dp)
                    .background(
                        Color.White,
                        shape = roundedCornerShape
                    ),
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
            modifier = Modifier
                .shadow(12.dp, shape = roundedCornerShape)
                .weight(1f)
                .clip(
                    shape = roundedCornerShape
                )
                .background(
                    Color.White,
                    shape = roundedCornerShape
                )
                .padding(start = 12.dp, end = 12.dp)
                .verticalScroll(rememberScrollState())

        ) {
            Column(
                modifier = Modifier.padding(top = 12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "Login")
                TextInput(
                    textState = loginViewModel.registerUser.value.login,
                    leadingIcon = Icons.Default.TextFields,
                    placeholderText = "Login"
                )
            }

            //TODO Change for email validation
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "E-mail")
                TextInput(
                    textState = loginViewModel.registerUser.value.email,
                    leadingIcon = Icons.Default.Email,
                    placeholderText = "E-mail"
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
                CaptionText(text = "Surname")
                TextInput(
                    textState = loginViewModel.registerUser.value.surname,
                    leadingIcon = Icons.Default.Person,
                    placeholderText = "Surname"
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "Patronymic")
                TextInput(
                    textState = loginViewModel.registerUser.value.patronymic,
                    leadingIcon = Icons.Default.Person,
                    placeholderText = "Patronymic"
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "Age")
                NumberInput(
                    textState = loginViewModel.registerUser.value.age,
                    leadingIcon = Icons.Default.Numbers,
                    placeholderText = "Age"
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "Weight")
                NumberInput(
                    textState = loginViewModel.registerUser.value.weight,
                    leadingIcon = Icons.Default.Numbers,
                    placeholderText = "Weight"
                )
            }

            Column(
                modifier = Modifier.padding(bottom = 12.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                CaptionText(text = "Height")
                NumberInput(
                    textState = loginViewModel.registerUser.value.height,
                    leadingIcon = Icons.Default.Numbers,
                    placeholderText = "Height"
                )
            }
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
                    password = loginViewModel.registerUser.value.password.value,
                    age = loginViewModel.registerUser.value.age.value,
                    email = loginViewModel.registerUser.value.email.value,
                    height = loginViewModel.registerUser.value.height.value,
                    patronymic = loginViewModel.registerUser.value.patronymic.value,
                    surname = loginViewModel.registerUser.value.surname.value,
                    weight = loginViewModel.registerUser.value.weight.value
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