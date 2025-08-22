package com.example.senya.ui.fragment.details

import com.airbnb.epoxy.EpoxyController
import com.example.senya.R
import com.example.senya.databinding.ModelHeaderImageBinding
import com.example.senya.ui.epoxy.ViewBindingKotlinModel
import com.squareup.picasso.Picasso

class HeaderEpoxyController(
    val imageUrls: ArrayList<String>
) : EpoxyController() {
    override fun buildModels() {
        imageUrls.forEachIndexed { index , url ->
            HeaderImageEpoxyModel(url).id(index).addTo(this)
        }
    }

    inner class HeaderImageEpoxyModel(
        val imageUrl: String
    ) : ViewBindingKotlinModel<ModelHeaderImageBinding>(R.layout.model_header_image) {
        override fun ModelHeaderImageBinding.bind() {
            Picasso.get().load(imageUrl).into(headerImage)
        }
    }
}