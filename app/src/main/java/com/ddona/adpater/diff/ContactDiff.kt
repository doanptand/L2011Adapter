package com.ddona.adpater.diff

import androidx.recyclerview.widget.DiffUtil
import com.ddona.adpater.model.Contact

class ContactDiff(
    private val oldContacts: List<Contact>,
    private val newContacts: List<Contact>,
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldContacts.size

    override fun getNewListSize() = newContacts.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldContacts[oldItemPosition].id == newContacts[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldContacts[oldItemPosition] == newContacts[newItemPosition]
    }
}