package com.example.active

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var retService: AlbumService
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text_view = findViewById<TextView>(R.id.text_view)

         retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

       // getRequestWithQueryParameters()
       // getRequestWithPathParameters(text_view)
        uploadAlbum(text_view)
    }

    private fun getRequestWithQueryParameters(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = retService.getAlbum(3)
            val title = response.body()?.title
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(applicationContext,title,Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun getRequestWithPathParameters(text_view:TextView){
        CoroutineScope(Dispatchers.IO).launch {

            val response = retService.getSortedAlbums(3)

            if (response.isSuccessful) {
                val albumsList = response.body()
                if (!albumsList.isNullOrEmpty()) {
                    albumsList?.let {
                        CoroutineScope(Dispatchers.Main).launch {
                            it.forEach { v ->
                                val result: String = " " + "Album Title : ${v.title}" + "\n" +
                                        " " + "Album id : ${v.id}" + "\n" +
                                        " " + "User id : ${v.userId}" + "\n\n\n"

                                text_view.append(result)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun uploadAlbum(text_view:TextView){
        val album = AlbumsItem(0,"My title",3)
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<AlbumsItem> = retService.uploadAlbum(album)
            if(response.isSuccessful){
                val receivedAlbumsItem:AlbumsItem? = response.body()

                receivedAlbumsItem?.let {
                    CoroutineScope(Dispatchers.Main).launch {

                            val result: String = " " + "Album Title : ${it.title}" + "\n" +
                                    " " + "Album id : ${it.id}" + "\n" +
                                    " " + "User id : ${it.userId}" + "\n\n\n"

                            text_view.text = result

                    }
                }

            }
        }
    }

}