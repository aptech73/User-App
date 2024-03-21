package com.example.userapp.ui.screens.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.userapp.R
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.databinding.FragmentUserListBinding
import com.example.userapp.domain.model.User
import com.example.userapp.ui.adapters.UserListAdapter
import com.example.userapp.utils.LoadState
import kotlinx.coroutines.launch

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    private var _binding : FragmentUserListBinding? = null
    val binding
        get() = _binding!!

    private val viewModel : UserListViewModel by activityViewModels()

    private val adapter = UserListAdapter(object : UserListAdapter.OnItemClickListener{
        override fun onUserItemClick(user : User) {
            val direction = UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(user)
            findNavController().navigate(direction)
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUi()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState.loadState) {
                        LoadState.LOADING -> setLoadingUi()
                        LoadState.SUCCESS -> setSuccessUi(uiState.userList)
                        LoadState.ERROR -> setErrorUi()
                    }
                }
            }
        }
    }

    private fun setUi() {
        binding.apply {
            userList.adapter = adapter
            userList.layoutManager = LinearLayoutManager(context)
            //getUserListFab.setOnClickListener { viewModel.getUserList() }
        }
    }

    private fun setLoadingUi() {
        binding.apply {
            loadIndicator.visibility = View.VISIBLE
            userList.visibility = View.GONE
        }
    }
    private fun setSuccessUi(users : List<User>) {
        binding.apply {
            adapter.submitList(users)
            loadIndicator.visibility = View.GONE
            userList.visibility = View.VISIBLE
        }
    }
    private fun setErrorUi() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}