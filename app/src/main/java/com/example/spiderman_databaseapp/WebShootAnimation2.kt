package com.example.spiderman_databaseapp

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import com.airbnb.lottie.LottieAnimationView

class WebShootAnimation2 (private val activity: Activity){
    fun start(durationMs: Long = 3500L){

        val lottieView = LottieAnimationView(activity).apply {
            setAnimation(R.raw.spidermann)
            repeatCount = 0
            //renderMode = LottieDrawable.RESTART
            playAnimation()
            layoutParams = FrameLayout.LayoutParams(
                600,
                600,
                Gravity.CENTER
            )
        }

        val dialogLayout = FrameLayout(activity).apply {
            setBackgroundColor(android.graphics.Color.parseColor("#000A12"))
            addView(lottieView)
        }

        val dialog = AlertDialog.Builder(activity)
            .setView(dialogLayout)
            .setCancelable(false)
            .create()
        dialog.show()

        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
            val intent = Intent(activity, MainActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                activity,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            activity.startActivity(intent, options.toBundle())
            activity.finish()
        }, durationMs)

    }
}