package com.platzi.ejerciciogian

import com.google.gson.annotations.SerializedName

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */

class CollectionModel{
    @SerializedName("nearby_restaurants")
    lateinit var collectionModelInner:List<CollectionModelInner>

    inner class CollectionModelInner {
        @SerializedName("restaurant")
        lateinit var collectionModelInner:CollectionModelObject

         inner class CollectionModelObject{
             @SerializedName("id") var id: String = ""
             @SerializedName("name") var name: String = ""
             @SerializedName("featured_image") var featured_image: String = ""
             @SerializedName("url") var url: String = ""
        }

    }
}