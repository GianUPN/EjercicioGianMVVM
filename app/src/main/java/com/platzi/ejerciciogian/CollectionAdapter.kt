package com.platzi.ejerciciogian

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_restaurant.view.*

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
class CollectionAdapter(val items : CollentionModel, val context: Context): RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       Picasso.with(context)
            .load(items.collectionModelInner.get(position).collectionModelInner.image_url)
            .into(holder.imgRestaurant)
        holder.txtRestaurant.text = items.collectionModelInner.get(position).collectionModelInner.title
    }

    override fun getItemCount(): Int {
        return items.collectionModelInner.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgRestaurant = view.imgRestaurant
        val txtRestaurant = view.txt_restaurant
    }

}