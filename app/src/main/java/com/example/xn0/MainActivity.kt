package com.example.xn0

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var p1name: TextView
    private lateinit var p2name: TextView
    private lateinit var p1score: TextView
    private lateinit var p2score: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.resetButton)
        p1name = findViewById(R.id.player1)
        p2name = findViewById(R.id.player2)
        p1score = findViewById(R.id.p1score)
        p2score = findViewById(R.id.p2score)

        p1name.text = intent?.extras?.getString("p1")
        p2name.text = intent?.extras?.getString("p2")


    }

    var player1 = mutableListOf<Int>()
    var player2 = mutableListOf<Int>()

    var times = 0

    fun ChocolateDisco(clickedview: View) {

        if (clickedview is Button) {
            if (winnerPlayer == 1 || winnerPlayer == 2 || winnerPlayer==3) {
                player1.clear()
                player2.clear()
                winnerPlayer = 0
                times = 0
                clear()
            }
            if (player1.size < 5 && player2.size < 5
                && winnerPlayer == 0 && clickedview.text == ""
            ) {

                if (times % 2 == 0) {
                    clickedview.setBackgroundColor(Color.CYAN)
                    clickedview.text = "X"
                    when (clickedview) {
                        button1 -> player1.add(1)
                        button2 -> player1.add(2)
                        button3 -> player1.add(3)
                        button4 -> player1.add(4)
                        button5 -> player1.add(5)
                        button6 -> player1.add(6)
                        button7 -> player1.add(7)
                        button8 -> player1.add(8)
                        button9 -> player1.add(9)
                    }


                } else {
                    clickedview.setBackgroundColor(Color.GREEN)
                    clickedview.text = "0"
                    when (clickedview) {
                        button1 -> player2.add(1)
                        button2 -> player2.add(2)
                        button3 -> player2.add(3)
                        button4 -> player2.add(4)
                        button5 -> player2.add(5)
                        button6 -> player2.add(6)
                        button7 -> player2.add(7)
                        button8 -> player2.add(8)
                        button9 -> player2.add(9)
                    }
                }
                times += 1


            }
        }
        winner()
    }

    var player1score = 0
    var player2score = 0
    var winnerPlayer = 0
    fun winner() {
        if (winnerPlayer == 0) {
            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winnerPlayer = 1
            } else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winnerPlayer = 1
            } else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
                winnerPlayer = 1
            } else if (player1.contains(9) && player1.contains(8) && player1.contains(7)) {
                winnerPlayer = 1
            } else if (player1.contains(9) && player1.contains(6) && player1.contains(3)) {
                winnerPlayer = 1
            } else if (player1.contains(9) && player1.contains(8) && player1.contains(7)) {
                winnerPlayer = 1
            } else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winnerPlayer = 1
            } else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winnerPlayer = 1
            } else if (player1.contains(7) && player1.contains(5) && player1.contains(3)) {
                winnerPlayer = 1
            } else if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winnerPlayer = 1
            } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
                winnerPlayer = 2
            } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
                winnerPlayer = 2
            } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
                winnerPlayer = 2
            } else if (player2.contains(9) && player2.contains(8) && player2.contains(7)) {
                winnerPlayer = 2
            } else if (player2.contains(9) && player2.contains(6) && player2.contains(3)) {
                winnerPlayer = 2
            } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
                winnerPlayer = 2
            } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
                winnerPlayer = 2
            } else if (player2.contains(7) && player2.contains(5) && player2.contains(3)) {
                winnerPlayer = 2
            }else if(player1.size + player2.size == 9 && winnerPlayer == 0){
                winnerPlayer=3
            }
            if (winnerPlayer == 1) {
                Toast.makeText(this, "FIRST PLAYER SLAYYYY", Toast.LENGTH_SHORT).show()
                player1score++
            } else if (winnerPlayer == 2) {
                player2score++
                Toast.makeText(this, "SECOND PLAYER SLAYYYY", Toast.LENGTH_SHORT).show()
            } else if (player1.size == 5 && player2.size == 4 && winnerPlayer == 3) {
                Toast.makeText(this, "Friendship won!", Toast.LENGTH_SHORT).show()
            }

            p1score.text = player1score.toString()
            p2score.text = player2score.toString()

        }
    }

    fun BitesTheDust(clickedview: View) {
        if (clickedview is Button) {
            player1.clear()
            player2.clear()
            winnerPlayer = 0
            player1score = 0
            player2score = 0
            times = 0
            clear()
        }
    }

    fun clear() {
        button1.setBackgroundColor(Color.rgb(55, 0, 179))
        button1.text = ""
        button2.setBackgroundColor(Color.rgb(55, 0, 179))
        button2.text = ""
        button3.setBackgroundColor(Color.rgb(55, 0, 179))
        button3.text = ""
        button4.setBackgroundColor(Color.rgb(55, 0, 179))
        button4.text = ""
        button5.setBackgroundColor(Color.rgb(55, 0, 179))
        button5.text = ""
        button6.setBackgroundColor(Color.rgb(55, 0, 179))
        button6.text = ""
        button7.setBackgroundColor(Color.rgb(55, 0, 179))
        button7.text = ""
        button8.setBackgroundColor(Color.rgb(55, 0, 179))
        button8.text = ""
        button9.setBackgroundColor(Color.rgb(55, 0, 179))
        button9.text = ""

    }
}





