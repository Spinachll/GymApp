package com.sporttest.gymapp.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sporttest.gymapp.ui.theme.BlueHorizontalGradient
import com.sporttest.gymapp.ui.theme.ControlsBackground
import com.sporttest.gymapp.ui.theme.DirtyBlue
import com.sporttest.gymapp.ui.theme.Grey
import com.sporttest.gymapp.ui.theme.defaultShape
import com.sporttest.gymapp.ui.theme.poppinsFamily

@Composable
fun ActivityCard(
    onCardClick: () -> Unit,
    onAdditionalButtonClick: () -> Unit,
    title: String,
    caption: String,
    additionalText: String
) {
    Card(
        modifier = Modifier
            .background(
                brush = BlueHorizontalGradient,
                shape = defaultShape,
                alpha = 0.2f
            )
            .padding(top = 12.dp, bottom = 12.dp, start = 20.dp, end = 20.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Black
        ),
        shape = RectangleShape,
        onClick = onCardClick,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = title,
                    fontFamily = poppinsFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                )
                Text(
                    text = caption,
                    fontFamily = poppinsFamily,
                    color = Grey,
                    maxLines = 1
                )
            }

            Column(
                Modifier
                    .weight(1f),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(0.dp)
                        .background(
                            color = ControlsBackground,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .then(Modifier.size(36.dp)),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "Additional Button",
                        tint = DirtyBlue
                    )
                }
                Text(
                    text = additionalText,
                    fontFamily = poppinsFamily,
                    color = Grey,
                )
            }
        }
    }
}