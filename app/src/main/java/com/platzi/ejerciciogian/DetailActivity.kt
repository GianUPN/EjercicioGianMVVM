package com.platzi.ejerciciogian

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */

class DetailActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(RestaurantViewModel::class.java) }
    private lateinit var restaurantId:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val restaurantName = intent.getStringExtra("RESTAURANTNAME")
        supportActionBar?.title = restaurantName
        val restaurantImage = intent.getStringExtra("RESTAURANTIMAGE")
        try {
            Picasso.with(this)
                .load(restaurantImage)
                .into(image)
        }catch (e: Exception){}
        restaurantId = intent.getStringExtra("RESTAURANTID")
        viewModel.getrestaurantDetails(restaurantId.toInt()).observe(
            this,
            Observer<RestaurantModel> {
                txt_city.setText(it.locationModelInner.city)
                txt_direccion.setText(it.locationModelInner.address)
                txt_review.setText(it.user_ratingModelInner.aggregate_rating)
                txt_timing.setText(it.timings)
            })
        fab.setOnClickListener(View.OnClickListener {
            //Un pequeño extra de AR, la API no me envia el modelo 3D, lo transforme a .GLB y subi a un STORAGE para consumirlo, es una PIZZA
            val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
            val intentUri = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                .appendQueryParameter(
                    "file",
                    "https://firebasestorage.googleapis.com/v0/b/vikingosdelivery-a427a.appspot.com/o/pizza.glb?alt=media&token=db047791-13ec-4911-80d0-335d054c50f2"
                )
                .appendQueryParameter("title", "Test Platzi")
                .build()
            sceneViewerIntent.data = intentUri
            sceneViewerIntent.setPackage("com.google.ar.core")
            startActivity(sceneViewerIntent)

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}