package com.ddona.adpater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddona.adpater.adapter.Contact2Adapter
import com.ddona.adpater.adapter.ContactAdapter
import com.ddona.adpater.databinding.ActivityMainBinding
import com.ddona.adpater.model.Contact

class MainActivity : AppCompatActivity() {
    //data: fake data-> Database, Apis, Firebase...vvv
    private val contacts = arrayListOf(
        Contact(1, "DoanPT1", "0977521942"),
        Contact(2, "DoanPT2", "0977521943"),
        Contact(3, "DoanPT3", "0977521944"),
        Contact(4, "DoanPT4", "0977521945"),
        Contact(5, "DoanPT5", "0977521946"),
    )

    private lateinit var adapter: ContactAdapter
//    private lateinit var adapter: Contact2Adapter


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //adapterView
        adapter = ContactAdapter()
        adapter.submitData(contacts)
//        adapter = Contact2Adapter()
//        adapter.submitList(contacts)

        binding.rvContacts.adapter = adapter
        binding.rvContacts.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.rvContacts)
    }

    private val callback = object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.START or ItemTouchHelper.END
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            contacts.removeAt(position)
//            adapter.submitList(contacts)
            adapter.submitData(contacts)
        }

    }
}