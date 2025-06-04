package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ChallengeDetailActivity : AppCompatActivity() {
    private val viewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_detail)

        val titleView = findViewById<TextView>(R.id.detailTitleTextView)
        val descView = findViewById<TextView>(R.id.detailDescriptionTextView)

        val challengeId = intent.getIntExtra("challengeId", -1)
        if (challengeId != -1) {
            viewModel.getById(challengeId) { challenge ->
                challenge?.let {
                    titleView.text = it.title
                    descView.text = it.description
                }
            }
        }
    }
}
