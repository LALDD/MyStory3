package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity2 : AppCompatActivity() {
/* Project after change*/
    private var editTextUsername:EditText?=null
    private var editTextPassword:EditText?=null
    private var buttonLogin:Button?=null
    private var checkboxView:CheckBox?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        connectViews()
        login()
       // checkFields()
    }
    private fun connectViews()  {

        editTextUsername=findViewById(R.id.etUsername)
        editTextPassword=findViewById(R.id.etPassword)
        buttonLogin=findViewById(R.id.btnLogin)
        checkboxView=findViewById(R.id.checkbox)

    }
    private fun login() {
        val arr:ArrayList<User> = ArrayList()
        arr.add(User("test1@test.com","1234"))
        arr.add(User("test2@test.com","1235"))
        arr.add(User("test3@test.com","1236"))
        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()
            val user = User(username, password)
            for (userArray in arr) {
                if (userArray.email == user.email
                    && userArray.passwrod == user.passwrod) {
                    //Toast.makeText(this, "Welcome ${user.email}", Toast.LENGTH_LONG).show()
                   finish()
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("email", userArray.email)
                    startActivity(i)
                    break
                }
                else{ Toast.makeText(this, "Check Your Data", Toast.LENGTH_LONG).show() }
            }
        }



    }
    private fun checkFields(){
        buttonLogin?.setOnClickListener {

            if (editTextUsername?.text?.isEmpty() == true
                || checkboxView?.isChecked!= true) {
                editTextUsername?.setError("Enter Your email")
            } else {
                if(editTextPassword?.text?.isEmpty() == true){
                    editTextPassword?.setError("Enter Your Passsword")}
            }
        }

    }
}
