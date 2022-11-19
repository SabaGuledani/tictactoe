package com.example.xn0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private lateinit var startbtn:Button
    private  lateinit var P1:EditText
    private  lateinit var P2:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        startbtn = findViewById(R.id.startButton)
        P1 = findViewById(R.id.first)
        P2 = findViewById(R.id.second)


        startbtn.setOnClickListener {
            if (P1.text.toString()!="" && P2.text.toString()!="") {
                var intent = Intent(this, MainActivity::class.java)

                intent.putExtra("p1", P1.text.toString())
                intent.putExtra("p2", P2.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "შეიყვანეთ სახელები", Toast.LENGTH_SHORT).show()
            }
        }
    }

}