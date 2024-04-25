package com.example.jeremyrv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class activity2 : AppCompatActivity() {
    lateinit var items:MutableList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        items = intent.getSerializableExtra("mascotasList") as? MutableList<Item> ?: mutableListOf()
        iniciar()
    }
        fun iniciar(){
            val recycl: RecyclerView = findViewById(R.id.recycleView)
            recycl.layoutManager = LinearLayoutManager(this)
            val adapter = Adapter(items)
            recycl.adapter=adapter


        }
    }
