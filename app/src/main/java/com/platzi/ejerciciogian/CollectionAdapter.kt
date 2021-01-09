package com.platzi.ejerciciogian

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_restaurant.view.*

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */
class CollectionAdapter(var items : CollectionModel, val context: Context): RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val RESTAURANTNAME = "RESTAURANTNAME"
        val RESTAURANTIMAGE = "RESTAURANTIMAGE"
        val RESTAURANTID = "RESTAURANTID"
        try {
            Picasso.with(context)
                .load(items.collectionModelInner.get(position).collectionModelInner.featured_image)
                .into(holder.imgRestaurant)
        }catch (e:Exception){
            Picasso.with(context)
                .load(R.drawable.cocktail)
                .into(holder.imgRestaurant)
        }
        holder.txtRestaurant.text = items.collectionModelInner.get(position).collectionModelInner.name
        holder.imgRestaurant.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(RESTAURANTNAME, items.collectionModelInner.get(position).collectionModelInner.name)
                putExtra(RESTAURANTIMAGE, items.collectionModelInner.get(position).collectionModelInner.featured_image)
                putExtra(RESTAURANTID, items.collectionModelInner.get(position).collectionModelInner.id)
            }
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return items.collectionModelInner.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgRestaurant = view.imgRestaurant
        var txtRestaurant = view.txt_restaurant
    }

}