package com.sporttest.gymapp.screens.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sporttest.gymapp.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    showAccountButton: Boolean = true,
    onAccountButtonClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .height(34.dp),
        title = {
            Text(
                modifier = Modifier
                    .fillMaxHeight(),
                text = title,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFamily
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        ),
        actions = {
            if (showAccountButton)
            IconButton(
                onClick = onAccountButtonClick
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account Button")
            }
        }

        /*
        navigationIcon = {
            if (isTopAppBarMenuVisible(navBackStackEntry?.destination?.route)) {
                IconButton(
                    onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Navigation Icon"
                    )
                }
            } else {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Button Icon"
                    )
                }
            }
        } */
    )
}