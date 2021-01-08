package com.platzi.ejerciciogian

import com.google.gson.annotations.SerializedName
/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */

class CollentionModel{
    @SerializedName("collections")
    lateinit var collectionModelInner:List<CollectionModelInner>

    inner class CollectionModelInner{
        @SerializedName("collection")
        lateinit var collectionModelInner:CollectionModelObject

        inner class CollectionModelObject{
            @SerializedName("collection_id") var collection_id:String = ""
            @SerializedName("res_count") var res_count:Int = 0
            @SerializedName("image_url") var image_url:String = ""
            @SerializedName("url") var url:String = ""
            @SerializedName("title") var title:String = ""
            @SerializedName("description") var description:String = ""
            @SerializedName("share_url") var share_url:String = ""
        }

    }
}