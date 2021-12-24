package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity2 : AppCompatActivity() {
    /*    Define Nullable Variables  */
    private var editTextUsername:EditText?=null
    private var editTextPassword:EditText?=null
    private var buttonLogin:Button?=null
    private var checkboxView:CheckBox?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        connectViews()/* Call Function to connect variables with views variables*/
        login()/* Call Function to allow user log in to the app */
    }
    private fun connectViews()  {
        editTextUsername=findViewById(R.id.etUsername)
        editTextPassword=findViewById(R.id.etPassword)
        buttonLogin=findViewById(R.id.btnLogin)
        checkboxView=findViewById(R.id.checkbox)
    }
    private fun login() {
        val arr:ArrayList<User> = ArrayList()//Define array of users
        arr.add(User("test1@test.com","1234"))
        arr.add(User("test2@test.com","1235"))
        arr.add(User("test3@test.com","1236"))
        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()
            val user = User(username, password)
            for (userArray in arr) {//check if user has correct email and password
                if (userArray.email == user.email
                    && userArray.passwrod == user.passwrod && checkboxView?.isChecked== true) {
                   finish()//End the current Activity
                    val i = Intent(this, MainActivity::class.java)//move to main activity
                    i.putExtra("email", userArray.email)//move the user email to main activity
                    startActivity(i)//Start moving
                    break // To end and Exit the loop
                }
                else{ //Message appear to user
                    Toast.makeText(this, "Check Your Data", Toast.LENGTH_LONG).show() }
            }
        }
    }

}
