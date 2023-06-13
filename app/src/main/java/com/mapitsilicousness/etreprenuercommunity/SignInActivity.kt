package com.mapitsilicousness.etreprenuercommunity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // DECLARATIONS
        val login_signin = findViewById<Button>(R.id.login_signin)
        val login_create = findViewById<TextView>(R.id.login_create)
        // input values parsed
        val email = findViewById<TextInputEditText>(R.id.login_input_email).text.toString()
        val password = findViewById<TextInputEditText>(R.id.login_input_password).text.toString()

        login_signin.setOnClickListener{
            val i = Intent(this , MainActivity::class.java)
            startActivity(i)

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }

        login_create.setOnClickListener {
            val i = Intent(this , SignUpActivity::class.java)
            startActivity(i)
        }
    }
}