package com.sporttest.gymapp.screens.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextInput(

) {
    val textValue = rememberSaveable {
        mutableStateOf("")
    }

    TextField(
        value = textValue.value,
        onValueChange = {
            textValue.value =  it
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    TextInput()
}