package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ChallengeAdapter
    private val viewModel: ChallengeViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ChallengeAdapter { challenge ->
            val intent = Intent(this, ChallengeDetailActivity::class.java)
            intent.putExtra("challengeId", challenge.id)
            startActivity(intent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.challengeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addBtn = findViewById<FloatingActionButton>(R.id.addChallengeButton)
        addBtn.setOnClickListener {
            startActivity(Intent(this, AddChallengeActivity::class.java))
        }

        viewModel.allChallenges.observe(this) {
            adapter.submitList(it)
        }
    }
}



