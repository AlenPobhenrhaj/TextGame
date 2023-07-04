package com.example.textgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.textgame.ui.CharacterClass
import com.example.textgame.ui.CharacterClassSelectionScreen
import com.example.textgame.ui.TitleScreen
import com.example.textgame.ui.WeaponScreen
import com.example.textgame.ui.theme.TextGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextGameTheme {
                // Create a NavController
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    // Create a NavHost with the NavController
                    NavHost(navController = navController, startDestination = "titleScreen") {
                        composable("titleScreen") { TitleScreen(navController) }
                        composable("characterClassSelectionScreen") { CharacterClassSelectionScreen(navController) }
                        composable("weaponScreen/{characterClass}") { backStackEntry ->
                            val characterClass = backStackEntry.arguments?.getString("characterClass")?.let { CharacterClass.valueOf(it) }

                            characterClass?.let {
                                WeaponScreen(characterClass = it) {
                                    // Navigate to the next screen when continue button is clicked.
                                    // Replace "nextScreen" with your next screen's route.
                                    navController.navigate("nextScreen")
                                }
                            } ?: Text("Character class not found")
                        }
                    }

                }
            }
        }
    }
}

