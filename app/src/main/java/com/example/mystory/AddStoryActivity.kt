package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddStoryActivity : AppCompatActivity() {
    /*********************************/
    /*    Define Nullable Variables  */
    /*********************************/
    private var editTextTitle: EditText? = null
    private var editTextSubTitle: EditText? = null
    private var editTextDesc: EditText? = null
    private var buttonAddStroy: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)
        connectViews()/* Call Function to connect variables with views variables*/
        fieledsValidation()/* Call Function To Add new Story */
    }
    private fun connectViews(){//Bind private variables with view variables
        editTextTitle=findViewById(R.id.etTilte)
        editTextSubTitle=findViewById(R.id.etSubTitle)
        editTextDesc=findViewById(R.id.etDescription)
        buttonAddStroy=findViewById(R.id.btnAdd)
    }
    private fun   fieledsValidation(){
        buttonAddStroy?.setOnClickListener { //lesson to button if it click by user
            val title=editTextTitle?.text.toString()//Extract text title
            val subTitle=editTextSubTitle?.text.toString()//Extract text sub title
            val decs=editTextDesc?.text.toString()//Extract description

            when{//check if the text is empty,then send error message
                title.isEmpty() -> {
                    editTextTitle?.error=getString(R.string.enter_title)
                }
                subTitle.isEmpty() ->{
                    editTextSubTitle?.error=getString(R.string.enter_sub_title)
                }
                decs.isEmpty() -> {
                    editTextDesc?.error=getString(R.string.enter_description)
                }
                else -> {
                    this.finish()//end this activity
                    //call class Intent and take title,subtitle and description and move to main activity
                    val i= Intent(this,MainActivity::class.java)
                    i.putExtra("title",title)//
                    i.putExtra("subtitle",subTitle)
                    i.putExtra("desc",decs)
                    startActivity(i)
                }
            }

        }
    }
}