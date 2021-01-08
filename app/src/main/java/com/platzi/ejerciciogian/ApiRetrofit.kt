package com.platzi.ejerciciogian

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
interface ApiRetrofit {
    @GET("collections?city_id=280")
    fun getCollections(@Header("user-key") token: String): Call<CollentionModel>

}