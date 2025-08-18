package com.example.senya.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.senya.data.Attraction
import com.example.senya.databinding.FragmetAttractionDetailBinding
import com.squareup.picasso.Picasso
import androidx.core.net.toUri

class AttractionDetailFragment : BaseFragment() {
    private var _binding: FragmetAttractionDetailBinding? = null
    private val binding get() = _binding!!
    private val attraction : Attraction by lazy {
        attractions.find{ it.id == safeArgs.attractionId}!!
    }
    private val safeArgs: AttractionDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmetAttractionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleText.text = attraction.title
        binding.descriptionText.text = attraction.description
        Picasso.get().load(attraction.imageUrls[0]).into(binding.imageView)
        binding.monthToVisit.text = attraction.monthToVisit
        binding.factsText.text = "${attraction.facts.size} facts"
        binding.factsText.setOnClickListener {
            // todo
        }
        binding.location.setOnClickListener {
            val uri = "geo:${attraction.location.latitude},${attraction.location.longitude}?z=9&q=${attraction.title}".toUri()
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
    override fun onPause() {
        super.onPause()
        view?.visibility = View.GONE  // Hide immediately
    }

    override fun onResume() {
        super.onResume()
        view?.visibility = View.VISIBLE
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
