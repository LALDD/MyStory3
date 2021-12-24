package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    /*    Define Nullable Variables  */
    private var textViewEmail: TextView? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolbarview: Toolbar? = null
    private var recyclerviwe:RecyclerView?=null
    private var navigationview: NavigationView? = null
    private var buttonAddSory:FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("email")//define user email variable
        connectViews()/* Call Function to connect variables with views variables*/
        textViewEmail?.text = email//set user email to
        setSupportActionBar(toolbarview)//In order to use toolbar view
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()//Call
        try{//Error Exceptions
            updateEmailInHeader(email!!)//Call function to update email in the header
        } catch (e:NullPointerException){}//To avoid system crash
        drawerClicks()
        openAddStoryActivity()
        displayStories()
    }
    private fun updateEmailInHeader(email: String) {
        val headerView = navigationview?.getHeaderView(0)//gets the header view at the specified position
        val textViewEamil = headerView?.findViewById<TextView>(R.id.tvEmail)
        textViewEamil?.text = email//set email value to be viewed in header
    }
    private fun setupDrawer() {//This function shows a Hamburger icon when drawer is closed and an arrow when drawer is open
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.open, R.string.close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }
  //when an item in the menu options is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }
    private fun connectViews() {//Bind the variables
        textViewEmail = findViewById(R.id.Emailview)
        drawerLayout = findViewById(R.id.drawer)
        toolbarview = findViewById(R.id.toolbar)
        navigationview = findViewById(R.id.navView)
        recyclerviwe = findViewById(R.id.storiesRecyclerview)
        buttonAddSory=findViewById(R.id.btnAddStory)
    }
    private fun drawerClicks() {
        navigationview?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()//End this activity and move to Login activity
                    val i=Intent(this,LoginActivity2::class.java)
                    startActivity(i)
                    true
                }
                else -> true
            }
        }
    }
   private fun openAddStoryActivity(){
       buttonAddSory?.setOnClickListener {//if user click add story button, respond by moving to add story activity
           val i=Intent(this,AddStoryActivity::class.java)
           startActivity(i)
       }
   }
    private fun displayStories(){
        val storiesArray= ArrayList<Story>()//Define Array of Stories
        //1
        storiesArray.add(Story(getString(R.string.story1_title1),getString(R.string.story1_subtitle)
        ,getString(R.string.story1_description)))
        //2
        storiesArray.add(Story(getString(R.string.story2_title),getString(R.string.story2_subtitle)
            ,getString(R.string.story2_description)))
        //3
        storiesArray.add(Story(getString(R.string.story3_title),getString(R.string.story3_subtitle)
            ,getString(R.string.story3_description)))
        //4
        storiesArray.add(Story(getString(R.string.story4_title),getString(R.string.story4_subtitle)
            ,getString(R.string.story4_description)))
        //Define custom Adapter
        val customAdapter=CustomAdapter(storiesArray,this)
        recyclerviwe?.adapter=customAdapter
        //check the title is not empty and then move the story details to
        if(intent.getStringExtra("title")!=null){
            val title=intent.getStringExtra("title")
            val subTitle=intent.getStringExtra("subtitle")
            val desc= intent.getStringExtra("desc")
            val newStory=Story(title!!,subTitle!!,desc!!)
            storiesArray.add(newStory)
            customAdapter.notifyDataSetChanged()//tells the recycler view that every single item should be updated
        }
    }

}
