package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ChallengeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(challenge: Challenge)

    @Query("SELECT * FROM challenges ORDER BY id DESC")
    fun getAllChallenges(): LiveData<List<Challenge>>

    @Query("SELECT * FROM challenges WHERE id = :challengeId LIMIT 1")
    suspend fun getChallengeById(challengeId: Int): Challenge?

    @Delete
    suspend fun delete(challenge: Challenge)
}