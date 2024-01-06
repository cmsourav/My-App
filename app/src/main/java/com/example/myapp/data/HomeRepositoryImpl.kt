package com.example.myapp.data

import com.example.myapp.model.Colleges
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class HomeRepositoryImpl @Inject constructor(
    private val firebaseDatabase : FirebaseDatabase
) : HomeRepository {

    override suspend fun fetchDataFromFirebase() : Resource<Colleges> {
        return try {
            suspendCoroutine { continuation ->
                firebaseDatabase.getReference("colleges")
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot : DataSnapshot) {
                            val collegeData = snapshot.getValue(Colleges::class.java)
                            val colleges = Colleges(
                                college = collegeData?.college
                            )
                            continuation.resume(Resource.Success(colleges))
                        }

                        override fun onCancelled(error : DatabaseError) {
                            continuation.resumeWithException(Exception("Firebase error: $error"))
                        }
                    })
            }
        } catch (e : Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}