package com.example.userapp.ui.screens.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.userapp.R
import com.example.userapp.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private var _binding : FragmentUserDetailsBinding? = null
    val binding
        get() = _binding!!

    private val viewModel : UserDetailsViewModel by activityViewModels()

    private val args : UserDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(args.userDbEntities)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}