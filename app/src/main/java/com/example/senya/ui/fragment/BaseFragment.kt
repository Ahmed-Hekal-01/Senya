package com.example.senya.ui.fragment

import androidx.fragment.app.Fragment
import com.example.senya.arch.AttractionViewModel
import com.example.senya.ui.MainActivity

abstract  class BaseFragment : Fragment() {
    protected val navController by lazy {
        (activity as MainActivity).navController
    }

    protected val activityViewModel : AttractionViewModel
        get() = (activity as MainActivity).viewModel
}