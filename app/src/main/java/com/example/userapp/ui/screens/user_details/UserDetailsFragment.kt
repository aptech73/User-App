package com.example.userapp.ui.screens.user_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.userapp.R
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.databinding.FragmentUserDetailsBinding
import com.example.userapp.utils.LoadState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {uiState ->
                    when (uiState.loadState) {
                        LoadState.LOADING -> setLoadingUi()
                        LoadState.SUCCESS -> setSuccessUi(uiState.user!!)
                        LoadState.ERROR -> setErrorUi()
                    }
                }
            }
        }
    }

    private fun setLoadingUi() {
        binding.apply {
            loadIndicator.visibility = View.VISIBLE
        }
    }
    private fun setSuccessUi(userDbEntities : UserDbEntities) {
        binding.apply {
            loadIndicator.visibility = View.GONE
        }
    }
    private fun setErrorUi() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}