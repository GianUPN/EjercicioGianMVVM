package com.platzi.ejerciciogian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

/**
 *  Created by Giancarlo Calderón on 08/01/2021.
 */

class ListadoActivity : AppCompatActivity() {

    private lateinit var adapter: CollectionAdapter
    private val viewModel by lazy { ViewModelProviders.of(this).get(CollectionViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)
        var recyclerView: RecyclerView = findViewById(R.id.recyclerCollection)
        viewModel.getListCollection().observe(this,Observer<CollentionModel>{
            var adapter:CollectionAdapter = CollectionAdapter(it,applicationContext)
            recyclerView.adapter = adapter
        })

    }
}