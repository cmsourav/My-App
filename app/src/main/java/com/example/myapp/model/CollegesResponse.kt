package com.example.myapp.model


data class Colleges(
    val college : List<College>? = null
)

data class College(
    val id : String? = null,
    val collegeName : String? = null,
    val state : String? = null,
    val district : String? = null,
    val country : String? = null,
    val university : String? = null,
    val approvals : List<String>? = null,
    val autonomous : Boolean? = null,
    val deemed : Boolean? = null,
    val courses : List<Course>? = null
)

data class Course(
    val courseId : String? = null,
    val stream : String? = null,
    val courseName : String? = null,
    val courseDuration : String? = null,
    val totalFee : String? = null,
    val feesPer : String? = null,
    val firstYear : String? = null,
    val secondYear : String? = null,
    val thirdYear : String? = null,
    val fourthYear : String? = null,
    val finalYear : String? = null,
    val admissionFee : String? = null,
)