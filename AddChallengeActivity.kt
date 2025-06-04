package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddChallengeActivity : AppCompatActivity() {
    private val viewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_challenge)

        val titleInput = findViewById<EditText>(R.id.editTitle)
        val descInput = findViewById<EditText>(R.id.editDescription)
        val saveBtn = findViewById<Button>(R.id.btnSave)

        saveBtn.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val desc = descInput.text.toString().trim()

            if (title.isNotEmpty() && desc.isNotEmpty()) {
                val challenge = Challenge(title = title, description = desc)
                viewModel.insert(challenge)
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
