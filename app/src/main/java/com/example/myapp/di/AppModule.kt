package com.example.myapp.di

import com.example.myapp.data.AuthRepository
import com.example.myapp.data.AuthRepositoryImpl
import com.example.myapp.data.HomeRepository
import com.example.myapp.data.HomeRepositoryImpl
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideFirebaseAuth() : FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl : AuthRepositoryImpl) : AuthRepository = impl

    @Provides
    fun provideFirebaseDatabase() : FirebaseDatabase = Firebase.database

    @Provides
    fun provideHomeRepository(impl : HomeRepositoryImpl) : HomeRepository = impl
}