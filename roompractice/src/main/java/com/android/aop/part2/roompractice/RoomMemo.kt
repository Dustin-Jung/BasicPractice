package com.android.aop.part2.roompractice

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "room_memo")
class RoomMemo {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var no: Long? = null
    @ColumnInfo
    var content: String = ""
    @ColumnInfo(name = "date")
    var datetime: Long = 0
    constructor(content:String, datetime:Long) {
        this.content = content
        this.datetime = datetime
    }
}