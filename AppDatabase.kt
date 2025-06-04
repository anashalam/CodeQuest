package com.example.myapplication


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Challenge::class], version = 1)
abstract class ChallengeDatabase : RoomDatabase() {
    abstract fun challengeDao(): ChallengeDao

    companion object {
        @Volatile
        private var INSTANCE: ChallengeDatabase? = null

        fun getDatabase(context: Context): ChallengeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ChallengeDatabase::class.java,
                    "challenge_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}