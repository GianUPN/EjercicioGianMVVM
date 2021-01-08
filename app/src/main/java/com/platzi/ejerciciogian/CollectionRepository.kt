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

    private lateinit var allCollectionsRest: MutableLiveData<CollentionModel>

    fun getallCollectionRestaurants(): LiveData<CollentionModel>{
        allCollectionsRest = MutableLiveData()
        var retrofit:Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var api = retrofit.create(ApiRetrofit::class.java)
        var call = api.getCollections(BuildConfig.APIKEY)
        call.enqueue(object : Callback<CollentionModel>{
            override fun onResponse(
                call: Call<CollentionModel>,
                response: Response<CollentionModel>
            ) {
                if (response.isSuccessful) {
                    allCollectionsRest.value = response.body()
                }
            }

            override fun onFailure(call: Call<CollentionModel>, t: Throwable) {
                Log.e("ZOMATO API ERROR",t.toString())
            }

        })
        return allCollectionsRest
    }
}