package com.example.dogs.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dogs.R
class MainActivity : AppCompatActivity() {
    private lateinit var navCtl: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Used for Back action button 
        navHostFragment= supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navCtl= navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navCtl)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navCtl,null)
    }

}
