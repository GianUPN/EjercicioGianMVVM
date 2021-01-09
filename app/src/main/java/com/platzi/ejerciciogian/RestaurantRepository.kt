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
 *  Created by Giancarlo Calderón on 09/01/2021.
 */
class RestaurantRepository {

    private lateinit var restaurantDetails: MutableLiveData<RestaurantModel>
    fun getRestauranDetails(resId:Int): LiveData<RestaurantModel> {
        restaurantDetails = MutableLiveData()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiRetrofit::class.java)
        val call = api.getRestaurant(resId,BuildConfig.APIKEY)
        call.enqueue(object : Callback<RestaurantModel> {
            override fun onResponse(
                call: Call<RestaurantModel>,
                response: Response<RestaurantModel>
            ) {
                if (response.isSuccessful) {
                    println(response.body())
                    restaurantDetails.value = response.body()
                }
            }

            override fun onFailure(call: Call<RestaurantModel>, t: Throwable) {
                Log.e("ZOMATO API ERROR",t.toString())
            }
        })
        return restaurantDetails
    }
}