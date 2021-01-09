package com.platzi.ejerciciogian

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
interface ApiRetrofit {
    @GET("geocode?lat=40.74&lon=-74.00")
    fun getCollections(@Header("user-key") token: String): Call<CollectionModel>

    @GET("restaurant?")
    fun getRestaurant(@Query("res_id") resId: Int, @Header("user-key") token: String): Call<RestaurantModel>

}