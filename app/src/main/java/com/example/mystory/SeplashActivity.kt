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
        moveToLoginScreen()//Call function
    }
    private fun moveToLoginScreen(){
        //looper delay 3000 milli second to allow enough time for loading
        Handler(Looper.myLooper()!!).postDelayed({
            finish()//End,release from memory
            val i=Intent(this,LoginActivity2::class.java)
            startActivity(i)
        },3000)
    }
}
