package com.sporttest.gymapp.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.ui.theme.PinkDark

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    isLoading: MutableState<Boolean> = rememberSaveable {
        mutableStateOf(false)
    },
    text: String = "MainButton",
    textColor: Color = Color.White,
    gradient: Brush = BlueHorizontalGradient,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(40f)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        shape = RoundedCornerShape(40f),
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient),
            contentAlignment = Alignment.Center
        ) {
            when(isLoading.value) {
                false -> Row(
                    modifier = Modifier
                        .align(Alignment.Center)
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        imageVector = Icons.AutoMirrored.Filled.Login,
                        contentDescription = "Main Button Content",
                        tint = textColor
                    )
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = text,
                        color = textColor,
                        fontWeight = FontWeight.Bold
                    )
                }
                true -> CircularProgressIndicator(
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.Center)
                        ,//.fillMaxHeight(),
                    color = Color.White,
                    backgroundColor = PinkDark,
                )
            }
            
        }
    }
}