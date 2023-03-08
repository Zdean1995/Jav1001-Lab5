package com.auchtermuchty.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting button ids from layout
        val btnPlayer1Increase: Button = findViewById(R.id.btn_player_1_increase)
        val btnPlayer1Decrease: Button = findViewById(R.id.btn_player_1_decrease)
        val btnPlayer2Increase: Button = findViewById(R.id.btn_player_2_increase)
        val btnPlayer2Decrease: Button = findViewById(R.id.btn_player_2_decrease)
        val btnReset: Button = findViewById(R.id.btn_reset)

        //Getting the life counter ids from layout
        val txtPlayer1Life: TextView = findViewById(R.id.txt_player_1_score)
        val txtPlayer2Life: TextView = findViewById(R.id.txt_player_2_score)

        //Getting the spinner from the layout
        val spnLifeChangeAmount: Spinner = findViewById(R.id.spn_change_amount)

        //Adding on click listeners to each button.  Life can be negative in magic the gathering so
        //a check for that is not needed
        btnPlayer1Increase.setOnClickListener {
            //This long ugly equation is so confusing that android studio still thinks it's a string when it's an int
            txtPlayer1Life.text = (txtPlayer1Life.text.toString().toInt() + spnLifeChangeAmount.selectedItem.toString().toInt()).toString()
        }

        btnPlayer1Decrease.setOnClickListener {
            txtPlayer1Life.text = (txtPlayer1Life.text.toString().toInt() - spnLifeChangeAmount.selectedItem.toString().toInt()).toString()
        }

        btnPlayer2Increase.setOnClickListener {
            txtPlayer2Life.text = (txtPlayer2Life.text.toString().toInt() + spnLifeChangeAmount.selectedItem.toString().toInt()).toString()
        }

        btnPlayer2Decrease.setOnClickListener {
            txtPlayer2Life.text = (txtPlayer2Life.text.toString().toInt() - spnLifeChangeAmount.selectedItem.toString().toInt()).toString()
        }

        //the on click listener for the reset button.  A toast tells the player that the life has been reset
        btnReset.setOnClickListener {
            val toast = Toast.makeText(this, "Life Reset", Toast.LENGTH_SHORT)
            toast.show()
            txtPlayer1Life.text = resources.getString(R.string.life_default)
            txtPlayer2Life.text = resources.getString(R.string.life_default)
        }

    }
}