package com.akshay.spotifyclonemvvmplyt.data.remote

import com.akshay.spotifyclonemvvmplyt.data.entity.Song
import com.akshay.spotifyclonemvvmplyt.other.Constants.SONGS_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONGS_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e:Exception) {
            emptyList<Song>()
        }

    }
}