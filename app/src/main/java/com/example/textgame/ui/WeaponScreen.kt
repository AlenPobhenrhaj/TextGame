package com.example.textgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.textgame.R
import kotlinx.coroutines.delay

enum class Weapon(val weaponImageId: Int, val description: String) {
    Axe(R.drawable.battle_axe, "This is the Weapon of your choice, the mighty Axe! With this are you ready to start your adventure? Click on the Progress Arrow to begin your journey"),
    Bow(R.drawable.broadhead_arrow, "This is the Weapon of your choice, the Bow of Faerdherim with unlimited arrows! With this are you ready to start your adventure? Click on the Progress Arrow to begin your journey"),
    Tome(R.drawable.burning_book, "This is the Weapon of your choice, the Tome of Ever Knowing Spells! With this are you ready to start your adventure? Click on the Progress Arrow to begin your journey")
}

@Composable
fun WeaponScreen(characterClass:CharacterClass , onContinueClicked: () -> Unit) {
    val weapon = when(characterClass) {
        CharacterClass.Warrior -> Weapon.Axe
        CharacterClass.Ranger -> Weapon.Bow
        CharacterClass.Wizard -> Weapon.Tome
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = weapon.weaponImageId),
                contentDescription = "Weapon Image",
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            )

            Spacer(Modifier.height(30.dp))

            TypewriterText(text = weapon.description)

            Spacer(Modifier.height(30.dp))

          /*  Button(
                onClick = onContinueClicked,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Continue")
            }*/

            Spacer(Modifier.height(30.dp))
        }

        BottomNavigation(
            backgroundColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red) },
                label = { Text("5 Hearts") },
                selected = true,
                onClick = { /*TODO*/ }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.Green) },
                label = { Text("Progress") },
                selected = false,
                onClick = { /*TODO*/ }
            )
            BottomNavigationItem(
                icon = { Image(painter = painterResource(id = weapon.weaponImageId), contentDescription = "Weapon Icon", modifier = Modifier.size(24.dp)) },
                label = { Text("Weapon") },
                selected = false,
                onClick = { /*TODO*/ }
            )
        }
       /* DiabloBottomNavigation(weapon = weapon, modifier = Modifier.align(Alignment.BottomCenter))*/
    }
}

@Composable
fun TypewriterText(text: String, speed: Int = 125) {
    val typewriterText = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val length = remember { mutableStateOf(0) }

    LaunchedEffect(text) {
        typewriterText.value = ""
        length.value = 0

        while (length.value < text.length) {
            delay(speed.toLong())
            typewriterText.value += text[length.value]
            length.value++
        }
    }

    Text(typewriterText.value, color = Color.White)
}




