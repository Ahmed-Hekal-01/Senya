package com.example.senya.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.senya.R
import com.example.senya.data.Attraction
import com.example.senya.data.AttractionResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val attractionList: List<Attraction> by lazy { parseAttraction() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById((R.id.nav_host_fragment)) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun parseAttraction(): List<Attraction> {
        val textFromFile =
            resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }

        val adapter: JsonAdapter<AttractionResponse> = moshi.adapter(AttractionResponse::class.java)
        return adapter.fromJson(textFromFile)!!.attractions
    }
}