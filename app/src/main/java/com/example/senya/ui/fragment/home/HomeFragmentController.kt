package com.example.senya.ui.fragment.home

import com.airbnb.epoxy.EpoxyController
import com.example.senya.R
import com.example.senya.data.Attraction
import com.example.senya.databinding.ViewHolderAttractionBinding
import com.example.senya.ui.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class HomeFragmentController(private val onClickedCallback: (String) -> Unit) : EpoxyController() {

    var isLoading: Boolean = false
        set(value) {
            field = value
            if (field) {
                requestModelBuild()
            }
        }
    var attractions = ArrayList<Attraction>()
        set(value) {
            field = value
            isLoading = false
            requestModelBuild()
        }

    override fun buildModels() {
        if (isLoading) {
            // todo show loading state
        }

        if (attractions.isEmpty()) {
            // todo show empty state
        }

        attractions.forEach { attraction ->
            AttractionEpoxyModel(attraction, onClickedCallback)
                .id(attraction.id)
                .addTo(this)
        }
    }

    data class AttractionEpoxyModel(
        val attraction: Attraction, val onClicked: (String) -> Unit
    ) : ViewBindingKotlinModel<ViewHolderAttractionBinding>(R.layout.view_holder_attraction) {
        override fun ViewHolderAttractionBinding.bind() {
            title.text = attraction.title
            Picasso.get().load(attraction.imageUrls[0]).into(image)
            text1.text = attraction.monthToVisit
            root.setOnClickListener {
                onClicked(attraction.id)
            }
        }

    }
}