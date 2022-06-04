package com.android.aop.part2.roompractice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomMemo::class], version = 1, exportSchema = false)
abstract class RoomHelper : RoomDatabase() {
    abstract fun roomMemoDao(): RoomMemoDAO
}