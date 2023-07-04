package com.example.textgame.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.textgame.ui.CharacterClass

class GameViewModel : ViewModel() {

    val navigateToWeaponScreen = MutableLiveData<String>()

    fun onCharacterClassSelected(characterClass: CharacterClass) {
        navigateToWeaponScreen.value = characterClass.name
    }
}
