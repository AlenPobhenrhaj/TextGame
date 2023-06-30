package com.example.textgame.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.textgame.viewmodel.GameViewModel

enum class CharacterClass {
    Warrior,
    Ranger,
    Wizard
}

@Composable
fun CharacterClassSelectionScreen() {
    // Getting the ViewModel
    val viewModel: GameViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose your class",
            fontSize = 30.sp
        )

        Spacer(Modifier.height(30.dp))

        CharacterClass.values().forEach { characterClass ->
            Button(
                onClick = { viewModel.onCharacterClassSelected(characterClass) },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = characterClass.name)
            }

            Spacer(Modifier.height(10.dp))
        }
    }
}

