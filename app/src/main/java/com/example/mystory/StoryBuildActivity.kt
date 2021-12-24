package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toolbar

class StoryBuildActivity : AppCompatActivity() {
    /*********************************/
    /*    Define Nullable Variables  */
    /*********************************/
    private var toolbarView:androidx.appcompat.widget.Toolbar?=null
    private var textViewStoryDesc:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_build)
        connectViews()//Call function to bind variables
        setSupportActionBar(toolbarView)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val title = intent.getStringExtra("title")//set title variable
        val description = intent.getStringExtra("desc")//set description variable
        supportActionBar?.title=title
        toolbarView?.setNavigationOnClickListener {
            onBackPressed()
        }
        textViewStoryDesc?.text=description
        textViewStoryDesc?.movementMethod=ScrollingMovementMethod()//This method Scrolling movement
    }
    private fun connectViews(){
        toolbarView=findViewById(R.id.toolbar)
        textViewStoryDesc=findViewById(R.id.tvDesc)
    }
}