package com.example.senya.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.senya.arch.AttractionViewModel
import com.example.senya.R

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController

    val viewModel: AttractionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById((R.id.nav_host_fragment)) as NavHostFragment
        navController = navHostFragment.navController
        viewModel.init(this)
    }

}