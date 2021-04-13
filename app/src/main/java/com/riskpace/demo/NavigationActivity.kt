package com.riskpace.demo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.riskpace.demo.ui.authentication.SignInActivity
import com.riskpace.demo.ui.authentication.SignUpActivity
import com.riskpace.demo.ui.home.HomeFragment
import com.riskpace.demo.viewmodel.AuthenticationViewModel

class NavigationActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var viewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val tv = findViewById<TextView>(R.id.textView)
        viewModel = ViewModelProvider(this).get(AuthenticationViewModel::class.java)
//        tv.text = "Welcome $name"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
            )
        )
        NavigationUI.setupWithNavController(navView, navController)
        navView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.navigation_home -> {
                NavOptions.Builder().setPopUpTo(R.id.mobile_navigation, true).build()
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.navigation_home)
                supportActionBar?.title = "Home"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                true
            }
            R.id.navigation_dashboard -> {
                if (isValidDestination(R.id.navigation_dashboard)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.navigation_dashboard)
                    supportActionBar?.title = "Dashboard"
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
                true
            }
            R.id.navigation_notifications -> {
                if (isValidDestination(R.id.navigation_notifications)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.navigation_notifications)
                }
                supportActionBar?.title = "Notification"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                true
            }
            else -> false
        }
    }

    private fun isValidDestination(destination: Int): Boolean {
        return destination != Navigation.findNavController(
            this,
            R.id.nav_host_fragment
        ).currentDestination!!.id
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Toast.makeText(applicationContext, "Log-out Successfully", Toast.LENGTH_LONG).show()
                val i = Intent(this, SignInActivity::class.java)

                startActivity(i)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}