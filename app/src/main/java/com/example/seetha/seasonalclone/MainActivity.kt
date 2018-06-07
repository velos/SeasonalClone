package com.example.seetha.seasonalclone

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.seetha.seasonalclone.adapters.SeasonalAdapter
import com.example.seetha.seasonalclone.models.ProduceItem

import kotterknife.bindView

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by bindView(R.id.rvProduce)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up LLM and add to RV
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        //set up test data
        val items = listOf(ProduceItem("Apples", "Fruit", "Apples are red."),
                ProduceItem("Bananas", "Fruit", "Bananas are tasty."),
                ProduceItem("Broccoli", "Vegetable", "Broccoli looks like little trees."),
                ProduceItem("Carrot", "Vegetable", "Bunnies like carrots."))

        //create adapter
        val adapter = SeasonalAdapter(items)

        //add adapter to RV
        recyclerView.adapter = adapter

    }

}
