package com.platzi.ejerciciogian

import com.google.gson.annotations.SerializedName

class CollentionModel{
    @SerializedName("collections")
    lateinit var collectionModelInner:List<CollectionModelInner>

    class CollectionModelInner{
        @SerializedName("collection")
        lateinit var collectionModelInner:CollectionModelObject

        class CollectionModelObject{
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