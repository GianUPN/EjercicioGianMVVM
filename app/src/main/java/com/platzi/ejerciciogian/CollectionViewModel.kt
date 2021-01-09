package com.platzi.ejerciciogian

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
class CollectionViewModel ():ViewModel(){
    private var repository: CollectionRepository = CollectionRepository()
    private var allCollectionModel: LiveData<CollectionModel> = repository.getallCollectionRestaurants()

    fun getListCollection(): LiveData<CollectionModel> {
        return allCollectionModel
    }
}