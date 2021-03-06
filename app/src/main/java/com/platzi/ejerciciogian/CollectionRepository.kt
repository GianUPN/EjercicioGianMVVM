package com.platzi.ejerciciogian

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
class CollectionRepository {

    private lateinit var allCollectionsRest: MutableLiveData<CollectionModel>

    fun getallCollectionRestaurants(): LiveData<CollectionModel>{
        allCollectionsRest = MutableLiveData()
        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiRetrofit::class.java)
        val call = api.getCollections(BuildConfig.APIKEY)
        call.enqueue(object : Callback<CollectionModel>{
            override fun onResponse(
                call: Call<CollectionModel>,
                response: Response<CollectionModel>
            ) {
                if (response.isSuccessful) {
                    println(response.body())
                    allCollectionsRest.value = response.body()
                }
            }

            override fun onFailure(call: Call<CollectionModel>, t: Throwable) {
                Log.e("ZOMATO API ERROR",t.toString())
            }

        })
        return allCollectionsRest
    }

}