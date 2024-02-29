package com.example.loginpage_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login_Screen : AppCompatActivity() {
    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val db = DataBaseHelper(this)

        loginButton = findViewById(R.id.loginButton_Button)
        loginEmail = findViewById(R.id.loginEmail_EditText)
        loginPassword = findViewById(R.id.loginPassworsd_EditText)

        loginButton.setOnClickListener {
            val emai = loginEmail.text.toString()
            val password = loginPassword.text.toString()
            if (emai.isNotEmpty() && password.isNotEmpty()) {
                if (db.cheakUser(emai,password)) {
                    Toast.makeText(this, "login is not Succees", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Invalid email and passworsd", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "please file all the failds", Toast.LENGTH_SHORT).show()
            }
        }

    }
}