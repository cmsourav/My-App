package com.example.myapp.model


data class Colleges(
    val college : List<College>? = null,
    val stream: List<String>? = null
)

data class College(
    val collegeID : String? = null,
    val collegeName : String? = null,
    val state : String? = null,
    val district : String? = null,
    val country : String? = null,
    val university : String? = null,
    val about : String? = null,
    val established : String? = null,
    val course : List<Course>? = null
)

data class Course(
    val courseId : String? = null,
    val courseName : String? = null,
    val stream : String? = null,
    val courseDuration : String? = null,
    val totalFee : String? = null,
    val admissionFee : String? = null,
    val feesPer : String? = null,
    val otherFee : String? = null,
    val hostelFee : String? = null,
    val firstYear : String? = null,
    val secondYear : String? = null,
    val thirdYear : String? = null,
    val fourthYear : String? = null,
    val finalYear : String? = null
)