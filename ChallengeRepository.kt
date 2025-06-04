package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao

class ChallengeRepository(private val dao: ChallengeDao) {

    val allChallenges: LiveData<List<Challenge>> = dao.getAllChallenges()

    suspend fun insert(challenge: Challenge) {
        dao.insert(challenge)
    }

    suspend fun getById(id: Int): Challenge? {
        return dao.getChallengeById(id)
    }

    suspend fun delete(challenge: Challenge) {
        dao.delete(challenge)
    }
}
