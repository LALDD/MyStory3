package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SeplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seplash)

        moveToLoginScreen()
    }
    private fun moveToLoginScreen(){
        //This code for delay in order to allow enough time to the user to see
        Handler(Looper.myLooper()!!).postDelayed({
            //destroy from memory
            finish()
            val i=Intent(this,LoginActivity2::class.java)
            startActivity(i)
        },3000)
    }
}
