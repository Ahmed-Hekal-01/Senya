package com.example.senya.ui.fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.net.toUri
import com.example.senya.R
import com.example.senya.databinding.FragmetAttractionDetailBinding
import com.squareup.picasso.Picasso

class AttractionDetailFragment : BaseFragment() {
    private var _binding: FragmetAttractionDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmetAttractionDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        activityViewModel.selectedAttractionLiveData.observe(viewLifecycleOwner) { attraction ->

            super.onViewCreated(view, savedInstanceState)

            binding.titleText.text = attraction.title
            binding.descriptionText.text = attraction.description
            Picasso.get().load(attraction.imageUrls[0]).into(binding.imageView)
            binding.monthToVisit.text = attraction.monthToVisit
            binding.factsText.text = "${attraction.facts.size} Facts"

            binding.factsText.setOnClickListener {
                val stringBuilder = StringBuilder("")
                attraction.facts.forEach {
                    stringBuilder.append("\u2022 $it")
                    stringBuilder.append("\n\n")
                }

                val message = stringBuilder.toString()
                    .substring(0, stringBuilder.toString().lastIndexOf("\n"))
                AlertDialog.Builder(requireContext(), R.style.dialog)
                    .setTitle("${attraction.facts.size} Facts")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which -> dialog.dismiss() }
                    .setNegativeButton("NO!") { dialog, which -> dialog.dismiss() }
                    .show()
            }

            binding.location.setOnClickListener {
                val uri =
                    "geo:${attraction.location.latitude},${attraction.location.longitude}?z=9&q=${attraction.title}".toUri()
                val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }

        }
    }

    override fun onPause() {
        super.onPause()
        view?.visibility = View.GONE
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
