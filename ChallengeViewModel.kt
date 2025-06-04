package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ChallengeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ChallengeRepository
    val allChallenges: LiveData<List<Challenge>>

    init {
        val dao = ChallengeDatabase.getDatabase(application).challengeDao()
        repository = ChallengeRepository(dao)
        allChallenges = repository.allChallenges
    }

    fun insert(challenge: Challenge) = viewModelScope.launch {
        repository.insert(challenge)
    }

    fun getById(id: Int, onResult: (Challenge?) -> Unit) = viewModelScope.launch {
        val challenge = repository.getById(id)
        onResult(challenge)
    }

    fun delete(challenge: Challenge) = viewModelScope.launch {
        repository.delete(challenge)
    }
}
