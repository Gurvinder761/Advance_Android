package com.labtest1.ui.lists

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.labtest1.EditPageActivity
import com.labtest1.R
import com.labtest1.adapters.UserAdapter
import com.labtest1.extensions.gone
import com.labtest1.extensions.visible
import com.labtest1.viewmodel.LocationViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_maps.*

class ListDataFragment : Fragment() {

    private lateinit var galleryViewModel: LocationViewModel
    private val adapter = UserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(LocationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_list, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewUsers.layoutManager = LinearLayoutManager(requireContext())

        recyclerViewUsers.adapter = adapter
        adapter.clickListener = { user ->
            run {

                val addEditIntent = Intent(requireContext(), EditPageActivity::class.java)
                addEditIntent.putExtra("data", user)
                startActivity(addEditIntent)
            }
        }

        adapter.longClickListener = { user ->
            run {

                galleryViewModel.deleteEntry(user).observe(requireActivity(), Observer {
                    fetchAllUsers()
                    Toast.makeText(
                        requireContext(),
                        "User deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    fetchAllUsers()
                } else if (!newText.isNullOrEmpty()) {
                    searchUsers(newText)
                }
                return true
            }
        })
    }

    private fun searchUsers(textToSearch: String) {
        galleryViewModel.getAllDataByName(textToSearch).observe(this, Observer {
            if (it.isNullOrEmpty()) {
                textViewNoUsers.visible()
                recyclerViewUsers.gone()
            } else {
                textViewNoUsers.gone()
                recyclerViewUsers.visible()
                adapter.collection = it
            }
        })
    }

    private fun fetchAllUsers() {
        galleryViewModel.getAllEntries().observe(requireActivity(), Observer {
            if (it.isNullOrEmpty()) {
                textViewNoUsers.visible()
                recyclerViewUsers.gone()
            } else {
                textViewNoUsers.gone()
                recyclerViewUsers.visible()
                adapter.collection = it
            }
        })
    }

    override fun onResume() {
        super.onResume()
        fetchAllUsers()
    }
}