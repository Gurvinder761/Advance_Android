package com.labtest1.ui.maps

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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.ui.IconGenerator
import com.labtest1.EditPageActivity
import com.labtest1.R
import com.labtest1.database.entities.LocationData
import com.labtest1.viewmodel.LocationViewModel
import kotlinx.android.synthetic.main.fragment_maps.*

class MapsFragment : Fragment(), OnMapReadyCallback {

    lateinit var locationViewModel: LocationViewModel
    private lateinit var mMap: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_maps, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    fetchAllData()
                } else if (!newText.isNullOrEmpty()) {
                    searchUsers(newText)
                }
                return true
            }
        })
    }

    private fun searchUsers(textToSearch: String) {
        locationViewModel.getAllDataByName(textToSearch).observe(this, Observer {
            mMap.clear()
            if (!it.isNullOrEmpty()) {
                for (data in it) {

                    val iconGenerator = IconGenerator(requireContext())
                    val bitmap = iconGenerator.makeIcon(data.name)
                    val markerOptions =
                        MarkerOptions().position(LatLng(data.latitude, data.longitude))
                            .title(data.name).snippet("${data.gender},${data.country},${data.dob}")
                            .icon(BitmapDescriptorFactory.fromBitmap(bitmap))
                    val marker = mMap.addMarker(
                        markerOptions
                    )
                    marker.tag = data.uid
                }
                mMap.moveCamera(
                    CameraUpdateFactory.newLatLng(
                        LatLng(
                            it[it.lastIndex].latitude,
                            it[it.lastIndex].longitude
                        )
                    )
                )

            } else {
                Toast.makeText(requireContext(), "No data found", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isZoomGesturesEnabled = true

        mMap.setOnMarkerClickListener {

            locationViewModel.getDataByID(it.tag.toString()).observe(this, Observer { it ->

                if (it != null) {
                    val addEditIntent = Intent(requireActivity(), EditPageActivity::class.java)
                    addEditIntent.putExtra(
                        "data",
                        LocationData(
                            it.uid,
                            it.name,
                            it.gender,
                            it.latitude,
                            it.longitude,
                            country = it.country,
                            dob = it.dob,
                            image = it.image
                        )
                    )
                    startActivity(addEditIntent)
                }
            })

            true
        }
    }

    override fun onResume() {
        super.onResume()
        fetchAllData()
    }

    private fun fetchAllData() {

        locationViewModel.getAllEntries().observe(this, Observer {
            mMap.clear()
            if (!it.isNullOrEmpty()) {
                for (data in it) {

                    val iconGenerator = IconGenerator(requireContext())
                    val bitmap = iconGenerator.makeIcon(data.name)
                    val markerOptions =
                        MarkerOptions().position(LatLng(data.latitude, data.longitude))
                            .title(data.name).snippet("${data.gender},${data.country},${data.dob}")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    val marker = mMap.addMarker(
                        markerOptions
                    )
                    marker.tag = data.uid
                }
                mMap.moveCamera(
                    CameraUpdateFactory.newLatLng(
                        LatLng(
                            it[it.lastIndex].latitude,
                            it[it.lastIndex].longitude
                        )
                    )
                )

            }
        })

    }

}