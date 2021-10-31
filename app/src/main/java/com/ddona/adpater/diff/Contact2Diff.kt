package com.ddona.adpater.diff

import androidx.recyclerview.widget.DiffUtil
import com.ddona.adpater.model.Contact

class Contact2Diff : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}