package com.example.project1

import FourLetterWordList
import android.R
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var guess = 3
        val word = FourLetterWordList.getRandomFourLetterWord() //caps already
        var stay = true

        if(guess==1)
        while (guess>=1 && stay){
            val simpleEditText = findViewById<View>(R.id.et_simple) as EditText
            val strValue = simpleEditText.text.toString().uppercase()
            val guessresult = checkGuess(strValue)
            if(guessresult.equals("XXXX")){
                stay = false
            }
            else{
                Toast.makeText(applicationContext, "you have "+guess.toString()+" guesses left",
                    Toast.LENGTH_SHORT).show()
                guess--
            }
        }
    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}