package com.example.selfpromoapp

data class Message(
    val contactName: String,
    val contactNumber: String,
    val myDisplayName: String,
    val includeJunior: Boolean,
    val jobTitle: String?,
    val immediateStart: Boolean,
    val startDate: String?
) : java.io.Serializable {
    fun getFullJobDescription() = if (includeJunior) "a Junior $jobTitle" else "an $jobTitle"
    fun getGetAvailability() = if (immediateStart) "immediately" else "from $startDate"
}