package com.example.spiderman_databaseapp


import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import android.text.InputType
import androidx.core.graphics.red
import com.example.spiderman_databaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        sharedPreferences = this.getSharedPreferences("com.example.spiderman_databaseapp", MODE_PRIVATE)


    }



    fun enterButton(view: View){
        val spideyNameText = binding.editText.text
        val spideyPassword2 = binding.pswText.text
        val webAnim = WebShootAnimation(this)


        val message = when{
            spideyNameText.isNullOrEmpty() && spideyPassword2.isNullOrEmpty() ->
                "⚠️ Username and Password cannot be empty!"
            spideyNameText.isNullOrEmpty() ->
                "⚠️ Username cannot be empty!"
            spideyPassword2.isNullOrEmpty() ->
                "⚠️ Password cannot be empty!"
            else -> null


        }
        //Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        if (message != null){
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
            return
        }
        webAnim.start(2500L)

        onDestroy()




    }

    fun registerButton(view: View){

        //val webAnimRegister = WebShootAnimation(this)

        val intent = Intent(this@MainActivity, MainActivity2::class.java)
        startActivity(intent)

        onDestroy()



    }
}