package com.example.android.guesstheword.screens.shop

import android.util.Log
import androidx.lifecycle.ViewModel

class ShopCartModel : ViewModel(){
    // The current word
    var word = ""
    // The current score
    var score = 0
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "fruits",
                "meat",
                "chicken",
                "pork",
                "vegetables",
                "letuce",
                "sweets",
                "sours",
                "sauces",
                "ram",
                "cheese",
                "cup",
                "plates",
                "books",
                "tables",
                "car",
                "chair",
                "bed",
                "duvets",
                "pilows",
                "pets"
        )
        wordList.shuffle()
    }

    init {
        resetList()
        nextWord()
        Log.i("ShopCartModel", "ShopCartModel created!")
    }
    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word = wordList.removeAt(0)
        }
    }
    /** Methods for buttons presses **/
    fun onSkip() {
        score--
        nextWord()
    }

    fun onCorrect() {
        score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}