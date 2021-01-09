package com.platzi.ejerciciogian

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 *  Created by Giancarlo Calderón on 09/01/2021.
 */
class RestaurantViewModel (): ViewModel(){
    private var repository: RestaurantRepository = RestaurantRepository()

    fun getrestaurantDetails(resId:Int): LiveData<RestaurantModel> {
        return repository.getRestauranDetails(resId)
    }
}