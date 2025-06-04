package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ChallengeAdapter(
    private val onItemClick: (Challenge) -> Unit
) : ListAdapter<Challenge, ChallengeAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Challenge>() {
            override fun areItemsTheSame(old: Challenge, new: Challenge) = old.id == new.id
            override fun areContentsTheSame(old: Challenge, new: Challenge) = old == new
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.titleTextView)
        private val desc = view.findViewById<TextView>(R.id.shortDescTextView)

        fun bind(challenge: Challenge) {
            title.text = challenge.title
            desc.text = challenge.description.take(100) + "..."
            itemView.setOnClickListener { onItemClick(challenge) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_challenge, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
