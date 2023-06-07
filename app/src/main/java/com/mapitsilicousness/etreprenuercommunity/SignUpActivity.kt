package com.mapitsilicousness.etreprenuercommunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val login_prompt = findViewById<TextView>(R.id.login_login_prompt)
        val login_login_prompt = findViewById<TextView>(R.id.login_signup)

        login_prompt.setOnClickListener {
            var i = Intent(this, SignInActivity::class.java)
            startActivity(i)
        }

        login_login_prompt.setOnClickListener{
            var i = Intent(this , MainActivity::class.java)
            startActivity(i)
        }
    }
}