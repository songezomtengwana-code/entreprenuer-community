package com.mapitsilicousness.etreprenuercommunity

import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = Firebase.auth

        val login_prompt = findViewById<TextView>(R.id.login_login_prompt)
        val login_login_prompt = findViewById<TextView>(R.id.login_signup)

        val email_value = findViewById<TextInputEditText>(R.id.signup_input_email)
        val password_value = findViewById<TextInputEditText>(R.id.signup_input_password)
        val displayName_value = findViewById<TextInputEditText>(R.id.signup_input_name)


        login_prompt.setOnClickListener {
            var i = Intent(this, SignInActivity::class.java)
            startActivity(i)
        }

        login_login_prompt.setOnClickListener{
            val email = email_value.text.toString()
            val password = password_value.text.toString()
            val username = displayName_value.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { it ->
                    if (it.isSuccessful) {
                        val user = auth.currentUser

                        val profileUpdates = userProfileChangeRequest {
                            displayName = username
                        }

                        var i = Intent(this, MainActivity::class.java)
                        startActivity(i)

                    } else {
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
    }
}