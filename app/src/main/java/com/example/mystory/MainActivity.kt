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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var textViewEmail: TextView? = null
    private var drawerLayout: DrawerLayout? = null
    private var toolbarview: Toolbar? = null
    private var navigationview: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = intent.getStringExtra("email")
        val x = 3//debugging
        connectViews()
        textViewEmail?.text = email
        setSupportActionBar(toolbarview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupDrawer()
        updateEmailInHeader(email!!)
        drawerClicks()
    }

    //week 6 day 4
    private fun updateEmailInHeader(email: String) {
        val headerView = navigationview?.getHeaderView(0)
        val textViewEamil = headerView?.findViewById<TextView>(R.id.tvEmail)
        textViewEamil?.text = email

    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.open, R.string.close
        )
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }
            else -> true
        }
    }

    private fun connectViews() {
        textViewEmail = findViewById(R.id.Emailview)
        drawerLayout = findViewById(R.id.drawer)
        toolbarview = findViewById(R.id.toolbar)
        navigationview = findViewById(R.id.navView)
    }

    private fun drawerClicks() {
        navigationview?.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    drawerLayout?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.logout -> {
                    finish()
                    val i=Intent(this,LoginActivity2::class.java)
                    startActivity(i)
                    true
                }
                else -> true
            }
        }
    }
}
