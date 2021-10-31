package com.ddona.adpater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.adpater.databinding.ItemContactBinding
import com.ddona.adpater.diff.ContactDiff
import com.ddona.adpater.model.Contact


class ContactAdapter :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    //old data
    private val contacts = arrayListOf<Contact>()

    //new data
    fun submitData(temp: List<Contact>) {
        val diff = ContactDiff(contacts, temp)
        val diffResult = DiffUtil.calculateDiff(diff)

        this.contacts.clear()
        this.contacts.addAll(temp)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size

    class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.imgAvatar.setImageResource(contact.image)
            binding.tvName.text = contact.name
            binding.tvPhone.text = contact.phone
        }
    }

}