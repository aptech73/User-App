package com.example.userapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.databinding.ItemUserBinding
import com.example.userapp.domain.model.User

class UserListAdapter (
    private val clickListener : OnItemClickListener
) : ListAdapter<User, UserListAdapter.UserListViewHolder>(UserListDiffCallback) {

    interface OnItemClickListener {
        fun onUserItemClick(user : User)
    }
    inner class UserListViewHolder(
        private val binding : ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user : User) {
            binding.apply {
                root.setOnClickListener { clickListener.onUserItemClick(user) }
                userEmail.text = user.email
                userName.text = "${user.firstName} ${user.lastName}"
                userImage.load(user.image)
            }
        }
    }

    private object UserListDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.firstName == newItem.firstName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)
    }
}