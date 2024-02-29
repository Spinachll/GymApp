package com.sporttest.gymapp.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sporttest.gymapp.ui.theme.BeigeMain
import com.sporttest.gymapp.ui.theme.BeigeMainTransparent
import com.sporttest.gymapp.ui.theme.ControlsBackground
import com.sporttest.gymapp.ui.theme.PlaceholderColor
import com.sporttest.gymapp.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    textState: MutableState<String>,
    placeholderText: String = "",
    leadingIcon: ImageVector? = null,
    isPasswordField: Boolean = false
) {
    TextField(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth(),
        value = textState.value,
        onValueChange = {
            textState.value = it
        },
        shape = RoundedCornerShape(size = 40f),
        singleLine = true,
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isPasswordField) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        textStyle = TextStyle(fontFamily = poppinsFamily, fontSize = 18.sp),

        placeholder = {
            Text(
                text = placeholderText,
                color = PlaceholderColor,
                fontFamily = poppinsFamily,
                fontSize = 18.sp
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = ControlsBackground,
            unfocusedContainerColor = ControlsBackground,
            disabledContainerColor = Color.Transparent,
            cursorColor = Color.Black,
            selectionColors = TextSelectionColors(
                backgroundColor = BeigeMainTransparent,
                handleColor = BeigeMain
            ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
        ),
        leadingIcon = {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "Slide month to right",
                    modifier = Modifier
                        .padding(0.dp)
                        .width(24.dp)
                        .height(24.dp),
                    tint = PlaceholderColor
                )
            }
        }
    )
}