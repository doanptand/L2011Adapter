package com.ddona.adpater.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ddona.adpater.databinding.ItemContactBinding
import com.ddona.adpater.databinding.ItemContactNewTypeBinding
import com.ddona.adpater.diff.ContactDiff
import com.ddona.adpater.model.Contact


class ContactAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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


    override fun getItemViewType(position: Int): Int {
        if (contacts[position].id % 2 == 0)
            return 1
        else
            return 0
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

    class ViewHolderNew(private val binding: ItemContactNewTypeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.imgAvatar.setImageResource(contact.image)
            binding.tvName.text = contact.name
            binding.tvPhone.text = contact.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            return ViewHolderNew(
                ItemContactNewTypeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        } else {
            return ViewHolder(
                ItemContactBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == 1) {
            (holder as ViewHolderNew).bind(contacts[position])
        } else {
            (holder as ViewHolder).bind(contacts[position])
        }
    }

}