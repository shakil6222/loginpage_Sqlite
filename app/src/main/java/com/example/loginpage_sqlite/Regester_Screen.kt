package com.example.loginpage_sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Regester_Screen : AppCompatActivity() {

    lateinit var nameeditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEdtiText: EditText
    lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regester_screen)

        nameeditText = findViewById(R.id.registerName_EditText)
        emailEditText = findViewById(R.id.registerEmail_EditText)
        passwordEdtiText = findViewById(R.id.registerPassworsd_EditText)

        registerButton = findViewById(R.id.registerButton_Button)

        val db = DataBaseHelper(this)


        registerButton.setOnClickListener {
            val name = nameeditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEdtiText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                val result = db.addUser(name, email, password)

                if (result != -1L) {
                    toast("Registration Successful")
                    startActivity(Intent(this, Login_Screen::class.java))
                } else {
                    toast("Registration is failed")
                }

            } else {
                toast("please file all the fields")
            }

        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}