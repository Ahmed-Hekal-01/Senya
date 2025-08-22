package com.example.senya.ui.fragment.details

import com.airbnb.epoxy.EpoxyController
import com.example.senya.R
import com.example.senya.data.Attraction
import com.example.senya.databinding.ModelDescriptionBinding
import com.example.senya.databinding.ModelFactsBinding
import com.example.senya.databinding.ModelFactsHeaderBinding
import com.example.senya.databinding.ModelMonthToVisitBinding
import com.example.senya.ui.epoxy.ViewBindingKotlinModel

class ContentEpoxyController(
    private val attraction: Attraction
) : EpoxyController() {
    override fun buildModels() {

        DescriptionEpoxyModel(attraction.description).id("description").addTo(this)

        FactsHeaderEpoxyModel("${attraction.facts.size} Facts").id("facts_header").addTo(this)

        attraction.facts.forEachIndexed { index, fact->
            FactEpoxyModel(fact).id("fact_${index}").addTo(this)
        }

        MonthToVisitEpoxyModel(attraction.monthToVisit).id("month_to_visit").addTo(this)
    }

    data class MonthToVisitEpoxyModel(
        val monthsToVisit: String
    ) : ViewBindingKotlinModel<ModelMonthToVisitBinding>(R.layout.model_month_to_visit) {
        override fun ModelMonthToVisitBinding.bind() {
           monthToVisit.text = monthsToVisit
        }

    }

    data class DescriptionEpoxyModel(
        val description: String
    ) : ViewBindingKotlinModel<ModelDescriptionBinding>(R.layout.model_description) {
        override fun ModelDescriptionBinding.bind() {
            TextView.text = description
        }

    }

    data class FactsHeaderEpoxyModel(
        val factsText: String
    ) : ViewBindingKotlinModel<ModelFactsHeaderBinding>(R.layout.model_facts_header) {
        override fun ModelFactsHeaderBinding.bind() {
            factsTextIcon.text = factsText
        }

    }
    data class FactEpoxyModel(
        val fact : String
    ) : ViewBindingKotlinModel<ModelFactsBinding>(R.layout.model_facts) {
        override fun ModelFactsBinding.bind() {
            factsText.text = fact
        }

    }
}
