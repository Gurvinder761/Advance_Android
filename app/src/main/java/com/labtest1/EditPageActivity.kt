package com.labtest1

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.dhaval2404.imagepicker.ImagePicker
import com.labtest1.database.entities.LocationData
import com.labtest1.database.utils.DbUtils.generateIDForData
import com.labtest1.extensions.gone
import com.labtest1.extensions.toDate
import com.labtest1.extensions.toReadableFormat
import com.labtest1.extensions.visible
import com.labtest1.viewmodel.LocationViewModel
import kotlinx.android.synthetic.main.activity_edit_page.*
import java.io.File
import java.util.*

class EditPageActivity : AppCompatActivity() {
    lateinit var userViewModel: LocationViewModel
    var oldLocationData: LocationData? = null
    var selectedImage = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_page)
        supportActionBar?.title = "Add/Edit Data"
        userViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)
        oldLocationData = intent.getParcelableExtra("data")
        setupUI()
        setOldUserData()
    }

    private fun setOldUserData() {
        if (oldLocationData != null) {
            editTextLatitude.setText("${oldLocationData!!.latitude}")
            editTextName.setText(oldLocationData!!.name)
            editTextGender.setText(oldLocationData!!.gender)
            editTextLongitude.setText("${oldLocationData!!.longitude}")
            editTextDOB.setText(oldLocationData!!.dob.toReadableFormat())
            editTextCountry.setText(oldLocationData!!.country)
            selectedImage = oldLocationData!!.image
            imageUser.setImageURI(Uri.fromFile(File(selectedImage)))

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit_page, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (selectedImage.isEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please select user image", Toast.LENGTH_SHORT)
                .show()
            return false
        }


        if (editTextName.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please enter name", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (editTextGender.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please enter age", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        if (editTextDOB.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please select date of birth", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (editTextLatitude.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please enter latitude", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        if (editTextLongitude.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please enter longitude", Toast.LENGTH_SHORT)
                .show()
            return false
        }

        if (editTextCountry.text.isNullOrEmpty()) {
            Toast.makeText(this@EditPageActivity, "Please select country", Toast.LENGTH_SHORT)
                .show()
            return false
        }


        val hashCode = if (oldLocationData == null) {
            generateIDForData(
                editTextName.text.toString(),
                subTitle = editTextGender.text.toString(),
                longitude = editTextLongitude.text.toString().toDouble(),
                latitude = editTextLatitude.text.toString().toDouble(),
                country = editTextCountry.text.toString(),
                dob = editTextDOB.text.toString()
            )
        } else {
            oldLocationData!!.uid
        }
        val data = LocationData(
            hashCode, editTextName.text.toString(), gender = editTextGender.text.toString(),
            longitude = editTextLongitude.text.toString().toDouble(),
            latitude = editTextLatitude.text.toString().toDouble(),
            country = editTextCountry.text.toString(),
            dob = editTextDOB.text.toString().toDate() ?: Date(),
            image = selectedImage
        )

        if (oldLocationData != null) {
            userViewModel.updateEntry(data).observe(this, Observer {
                Toast.makeText(
                    this@EditPageActivity,
                    "Data updated successfully",
                    Toast.LENGTH_SHORT
                )
                    .show()
                finish()
            })
        } else {
            userViewModel.getDataByID(hashCode)
                .observe(this, androidx.lifecycle.Observer { foundLocationData: LocationData? ->
                    if (foundLocationData == null) {
                        userViewModel.addEntry(data).observe(this, Observer {
                            Toast.makeText(
                                this@EditPageActivity,
                                "Data saved successfully",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            finish()
                        })

                    } else {
                        Toast.makeText(
                            this@EditPageActivity,
                            "Data already present in database",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                })
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupUI() {

        if (oldLocationData != null) {
            buttonDeleteData.visible()
            buttonDeleteData.setOnClickListener {
                userViewModel.deleteEntry(oldLocationData!!).observe(this, Observer {
                    Toast.makeText(
                        this@EditPageActivity,
                        "User deleted successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                })
            }

        } else {
            buttonDeleteData.gone()
        }
        editTextDOB.setOnClickListener {
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    var monthString = ""
                    if ((month + 1) < 10) {
                        monthString = "0${month + 1}"
                    } else {
                        monthString = "${month + 1}"
                    }
                    var dayString = ""
                    if (dayOfMonth < 10) {
                        dayString = "0${dayOfMonth}"
                    } else {
                        dayString = "$dayOfMonth"
                    }

                    editTextDOB.setText(
                        "$dayString-$monthString-$year"
                    )
                },
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        editTextCountry.setOnClickListener {
            val countrySelectionIntent =
                Intent(this@EditPageActivity, CountrySelectionActivity::class.java)
            startActivityForResult(countrySelectionIntent, 1001)
        }

        imageUser.setOnClickListener {
            ImagePicker.with(this)
                .crop()                    //Crop image(Optional), Check Customization for more option
                .compress(1024)            //Final image size will be less than 1 MB(Optional)
                .maxResultSize(
                    1080,
                    1080
                )    //Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            editTextCountry.setText(data?.getStringExtra("country") ?: "")
        } else if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val fileUri = data?.data
            imageUser.setImageURI(fileUri)
            selectedImage = ImagePicker.getFilePath(data)!!
        }
    }
}