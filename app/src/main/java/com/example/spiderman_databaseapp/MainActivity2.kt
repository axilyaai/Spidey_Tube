package com.example.spiderman_databaseapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.example.spiderman_databaseapp.databinding.ActivityMain2Binding
import com.example.spiderman_databaseapp.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
    }
    fun registerButton(view:View){
        val userNameText = binding.editTextRegister.text
        val userPassword = binding.pswTextRegister.text
        val webAnimation = WebShootAnimation2(this)

        val message = when{
            userNameText.isNullOrEmpty() && userPassword.isNullOrEmpty() ->
                "⚠️ Username and Password cannot be empty!"
            userNameText.isNullOrEmpty() ->
                "⚠️ Username cannot be empty!"
            userPassword.isNullOrEmpty() ->
                "⚠️ Password cannot be empty!"
            else ->
                "✅ Registration successful!"
        }
        Toast.makeText(this@MainActivity2, message, Toast.LENGTH_SHORT).show()



        webAnimation.start(3500L)
        onDestroy()




    }
}