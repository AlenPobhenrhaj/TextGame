package com.example.textgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.textgame.viewmodel.TitleViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.textgame.R


@Composable
fun TitleScreen(navController: NavController) {
    val viewModel: TitleViewModel = viewModel()

    val navigateToCharacterSelectionScreen by viewModel.navigateToCharacterSelectionScreen.observeAsState(initial = false)

    if (navigateToCharacterSelectionScreen) {
        navController.navigate("characterClassSelectionScreen") {
            // Ensures we won't navigate twice to the same route
            launchSingleTop = true
        }
        // Reset the navigation event
        viewModel.navigateToCharacterSelectionScreen.value = false
    }

    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cave_entrance),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your Game Title",
                color = Color.Red, // Updated the color import statement
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Button(
                onClick = { viewModel.onStartClick() },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(
                    text = "Start Game",
                    color = Color.White
                )
            }
        }
    }
}



/*@Preview(showBackground = true)
@Composable
fun PreviewTitleScreen() {
    TitleScreen()
}*/



