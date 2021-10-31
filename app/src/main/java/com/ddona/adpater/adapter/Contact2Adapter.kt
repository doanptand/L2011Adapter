package com.ddona.adpater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ddona.adpater.databinding.ItemContactBinding
import com.ddona.adpater.diff.Contact2Diff
import com.ddona.adpater.model.Contact


class Contact2Adapter :
    ListAdapter<Contact, Contact2Adapter.ViewHolder>(Contact2Diff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Contact2Adapter.ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = getItem(position)
        contact?.let {
            holder.bind(it)
        }
    }

    class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.imgAvatar.setImageResource(contact.image)
            binding.tvName.text = contact.name
            binding.tvPhone.text = contact.phone
        }
    }
}