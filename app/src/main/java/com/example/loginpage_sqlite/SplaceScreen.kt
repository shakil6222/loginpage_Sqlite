package com.example.loginpage_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.logging.Handler

class SplaceScreen : AppCompatActivity() {

    lateinit var splaceScreen: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        android.os.Handler().postDelayed(Runnable {
            val intent = Intent(this, Regester_Screen::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}