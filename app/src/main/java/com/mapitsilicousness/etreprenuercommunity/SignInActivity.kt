package com.mapitsilicousness.etreprenuercommunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val login_signin = findViewById<Button>(R.id.login_signin)
        val login_create = findViewById<TextView>(R.id.login_create)

        login_signin.setOnClickListener{
            var i = Intent(this , MainActivity::class.java)
            startActivity(i)
        }

        login_create.setOnClickListener {
            var i = Intent(this , SignUpActivity::class.java)
            startActivity(i)
        }
    }
}