package com.example.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.example.selfpromoapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

//    private var contactNameEditText: TextInputEditText? = null
//    private var contactNumberEditText: TextInputEditText? = null
//    private var myDisplayNameEditText: TextInputEditText? = null
//    private var startDateEditText: TextInputEditText? = null
//    private var juniorCheckBox: CheckBox? = null
//    private var immediateStartCheckBox: CheckBox? = null
//    private var jobTitleSpinner: Spinner? = null


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        contactNameEditText = findViewById(R.id.edit_text_contact_name)
//        contactNumberEditText = findViewById(R.id.edit_text_contact_number)
//        myDisplayNameEditText = findViewById(R.id.edit_text_my_display_name)
//        startDateEditText = findViewById(R.id.edit_text_start_date)
//        juniorCheckBox = findViewById(R.id.check_box_junior)
//        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
//        jobTitleSpinner = findViewById(R.id.spinner_job_title)

//        val previewButton: Button = findViewById(R.id.button_preview)
//
//        previewButton.setOnClickListener {
//            onPreviewClicked()
//        }

        binding.buttonPreview.setOnClickListener { onPreviewClicked() }
    }

    private fun onPreviewClicked() {
//        val testString = binding.editTextContactName?.text.toString() + ", " + binding.editTextContactNumber?.text.toString()
//        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
//        Log.d("Contact Name", "The name is: $testString")

        val contactName = binding.editTextContactName.text.toString()
        val contactNumber = binding.editTextContactNumber.text.toString()
        val myDisplayName = binding.editTextMyDisplayName.text.toString()
        val includeJunior = binding.checkBoxJunior.isChecked
            val jobTitle = binding.spinnerJobTitle.selectedItem?.toString()
        val immediateStart = binding.checkBoxImmediateStart.isChecked
        val startDate = binding.editTextStartDate.text.toString()

        Toast.makeText(
            this,
            "$contactName, $contactNumber, $myDisplayName, $includeJunior, $jobTitle, $immediateStart, $startDate",
            Toast.LENGTH_LONG
        ).show()

    }
}