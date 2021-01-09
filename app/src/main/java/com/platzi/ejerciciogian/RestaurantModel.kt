package com.platzi.ejerciciogian

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 *  Created by Giancarlo Calderón on 09/01/2021.
 */
class RestaurantModel {

    @SerializedName("location") lateinit var locationModelInner:LocationModelInner
    @SerializedName("name") lateinit var name: String
    @SerializedName("url") lateinit var url: String
    @SerializedName("cuisines") lateinit var cuisines: String
    @SerializedName("timings") lateinit var timings:String
    @SerializedName("user_rating")
        lateinit var user_ratingModelInner:UserRatingModelInner

    inner class LocationModelInner {
        @SerializedName("address") lateinit var address: String
        @SerializedName("locality") lateinit var locality: String
        @SerializedName("city") lateinit var city: String

    }
    inner class UserRatingModelInner{
        @SerializedName("aggregate_rating") lateinit var aggregate_rating: String
        @SerializedName("rating_text") lateinit var rating_text: String
        @SerializedName("rating_color") lateinit var rating_color: String
    }

}