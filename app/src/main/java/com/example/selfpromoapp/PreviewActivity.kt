package com.example.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.selfpromoapp.databinding.ActivityMainBinding
import com.example.selfpromoapp.databinding.ActivityPreviewBinding
import android.widget.Toast

class PreviewActivity : AppCompatActivity() {
     private lateinit var message: Message
     private lateinit var messagePreviewText: String

    private lateinit var binding: ActivityPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_preview)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val contactName = intent.getStringExtra("Contact Name")
//        val contactNumber = intent.getStringExtra("Contact Number")
//        val myDisplayName = intent.getStringExtra("My Display Name")
//        val includeJunior = intent.getBooleanExtra("Include Junior", false)
//        val jobTitle = intent.getStringExtra("Job Title")
//        val immediateStart = intent.getBooleanExtra("Immediate Start", false)
//        val startDate = intent.getStringExtra("Start Date")

        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Message", Message::class.java)!!
        } else {
            intent.getSerializableExtra("Message") as Message
        }

        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                I am able to start ${message.getGetAvailability()}
                
                Best Regards ${message.myDisplayName}
            """.trimIndent()

        //        binding.textViewMessage.text = "Name: $contactName\nContact Number: $contactNumber\nUsername: $myDisplayName\nStart Date: $startDate \nJunior: $includeJunior\nJob Title: $jobTitle"

        binding.textViewMessage.text = messagePreviewText
    }

    private fun setupButton() {
        binding.buttonSendMessage.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
//            test
        }
    }
}