package com.example.senya.arch

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.senya.data.Attraction

class AttractionViewModel : ViewModel() {

    private val repo = AttractionRepo()

    val attractionListLiveData = MutableLiveData< ArrayList<Attraction>>()

    val selectedAttractionLiveData = MutableLiveData<Attraction>()
    fun init(context: Context) {
        val attractionList = repo.parseAttraction(context)
        attractionListLiveData.postValue(attractionList)
    }

    fun onAttractionSelected(attractionId : String) {
        val attraction = attractionListLiveData.value?.find {
            it.id == attractionId
        } ?: return

        selectedAttractionLiveData.postValue(attraction)
    }
}