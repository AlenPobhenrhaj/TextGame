package com.example.textgame.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DiabloBottomNavigation(weapon: Weapon, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(Icons.Default.Favorite, contentDescription = null, tint = Color.Red)
            Text("5 Hearts", color = Color.White)
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Default.ArrowForward, contentDescription = null, tint = Color.Green)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = weapon.weaponImageId),
                contentDescription = "Weapon Icon",
                modifier = Modifier.size(24.dp)
            )
            Text("Weapon", color = Color.White)
        }
    }
}
