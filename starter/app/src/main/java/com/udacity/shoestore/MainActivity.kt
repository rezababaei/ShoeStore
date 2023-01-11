package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.shoeNavHostFragment) as NavHostFragment

        //setting custom toolbar
        setSupportActionBar(binding.toolbar)

        val  navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.toolbar, navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return this.findNavController(R.id.shoeNavHostFragment).navigateUp()
    }

}
