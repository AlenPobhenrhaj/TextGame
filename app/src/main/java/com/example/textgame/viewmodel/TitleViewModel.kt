package com.example.textgame.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TitleViewModel : ViewModel() {
    // Make sure this is a MutableLiveData to be able to modify it from the ViewModel
    val navigateToCharacterSelectionScreen = MutableLiveData(false)

    fun onStartClick() {
        // Handle start click
        navigateToCharacterSelectionScreen.value = true
    }
}

