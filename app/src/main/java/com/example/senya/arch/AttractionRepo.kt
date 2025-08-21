package com.example.senya.arch

import android.content.Context
import com.example.senya.R
import com.example.senya.data.Attraction
import com.example.senya.data.AttractionResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class AttractionRepo {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    fun parseAttraction(context: Context): ArrayList<Attraction> {

        val textFromFile =
            context.resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }

        val adapter: JsonAdapter<AttractionResponse> = moshi.adapter(AttractionResponse::class.java)
        return adapter.fromJson(textFromFile)!!.attractions as ArrayList
    }
}
