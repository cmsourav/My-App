package com.example.myapp.data

import com.example.myapp.model.Colleges

interface HomeRepository {

    suspend fun fetchDataFromFirebase() : Resource<Colleges>

}