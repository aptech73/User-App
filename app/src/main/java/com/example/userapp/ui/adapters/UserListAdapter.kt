package com.example.userapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.userapp.data.data_sources.local.model.UserDbEntities
import com.example.userapp.data.data_sources.network.model.User
import com.example.userapp.databinding.ItemUserBinding

class UserListAdapter (
    private val clickListener : OnItemClickListener
) : ListAdapter<UserDbEntities, UserListAdapter.UserListViewHolder>(UserListDiffCallback) {

    interface OnItemClickListener {
        fun onUserItemClick(userDbEntities: UserDbEntities)
    }
    inner class UserListViewHolder(
        private val binding : ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userDbEntities : UserDbEntities) {
            binding.apply {
                root.setOnClickListener { clickListener.onUserItemClick(userDbEntities) }
                userEmail.text = userDbEntities.email
                userName.text = "${userDbEntities.nameFirst} ${userDbEntities.nameLast}"
                userImage.load(userDbEntities.pictureThumbnail)
            }
        }
    }

    private object UserListDiffCallback : DiffUtil.ItemCallback<UserDbEntities>() {
        override fun areItemsTheSame(oldItem: UserDbEntities, newItem: UserDbEntities): Boolean {
            return oldItem.nameFirst == newItem.nameFirst
        }

        override fun areContentsTheSame(oldItem: UserDbEntities, newItem: UserDbEntities): Boolean {
            return oldItem == newItem
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