package com.cheezycode.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.daggermvvm.viewmodels.MainViewModel
import com.cheezycode.daggermvvm.R
import dagger.hilt.android.AndroidEntryPoint
import java.com.cheezycode.daggermvvm.CustomAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val recyclerview: RecyclerView
        get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        mainViewModel.productsLiveData.observe(this, Observer {
            //products.text =  it.joinToString { x -> x.title + "\n\n" }

            var strings: ArrayList<String> = ArrayList()
            for (i in it.indices) {
                strings.add(it[i].title)
            }

            val adapter = CustomAdapter(strings)
            recyclerview.adapter = adapter
        })


    }

}



















