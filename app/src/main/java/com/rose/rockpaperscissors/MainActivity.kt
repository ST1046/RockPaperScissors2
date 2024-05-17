package com.rose.rockpaperscissors

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var rockButton: Button
    private lateinit var scissorButton: Button
    private lateinit var paperButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var computerChoiceImage: ImageView
    private lateinit var playerChoiceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rockButton = findViewById(R.id. rockButton)
        scissorButton = findViewById(R.id. scissorsButton)
        paperButton = findViewById(R.id. paperButton)
        resultTextView = findViewById(R.id. resultTextView)
        computerChoiceImage = findViewById(R.id. computerChoiceImage)
        playerChoiceImage = findViewById(R.id. playerChoiceImage)

        ///set a function for each button to work with an image

        rockButton.setOnClickListener {
        playerChoiceImage.setImageResource(R.drawable.rock);
            play_turn("Rock")
        }

        paperButton.setOnClickListener {
            playerChoiceImage.setImageResource(R.drawable.paper)
            play_turn("Paper")
        }

        scissorButton.setOnClickListener {
            playerChoiceImage.setImageResource(R.drawable.scissors)
            play_turn("Scissors")
        }

    }

    //creating variables for the numbers the computer will choose from at random

    private fun play_turn(playerChoice: String) {
        var computer_choice = ""

        val random = Random
        var computerChoiceNumber: Int = random.nextInt(3) + 1;

        if (computerChoiceNumber == 1){
            computer_choice = "rock"
        }

        if (computerChoiceNumber == 2){
            computer_choice = "paper"
        }

        if(computerChoiceNumber ==3){
            computer_choice = "scissors"
        }

        //setting computer choices

        resultTextView.text=""
        if( computer_choice == "rock"){
            computerChoiceImage.setImageResource(R.drawable.rock)
        }

        if( computer_choice == "paper"){
            computerChoiceImage.setImageResource(R.drawable.paper)
        }

        if( computer_choice == "scissors"){
            computerChoiceImage.setImageResource(R.drawable.scissors)
        }

        //comparing the results between the player and the computer
        if ( computer_choice == playerChoice){
            resultTextView.text = "It's a tie!"
        }
        else if(playerChoice == "rock" && computer_choice =="scissors") {
            resultTextView.text = "You Win!"
        }
        else if(playerChoice == "rock" && computer_choice =="paper") {
            resultTextView.text = "Computer Wins!"
        }
        else if(playerChoice == "scissors" && computer_choice =="rock") {
            resultTextView.text = "Computer Wins!"
        }
        else if(playerChoice == "scissors" && computer_choice =="paper") {
            resultTextView.text = "You Win!"
        }
        else if(playerChoice == "paper" && computer_choice =="rock") {
            resultTextView.text = "You Win!"
        }
        else if(playerChoice == "paper" && computer_choice =="scissors") {
            resultTextView.text = "Computer Wins!"
        }
    }
}
