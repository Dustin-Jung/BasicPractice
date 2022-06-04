package com.android.aop.part2.roompractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.aop.part2.roompractice.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RoomRecyclerViewAdapter: RecyclerView.Adapter<RoomRecyclerViewAdapter.RoomViewHolder>() {

    var helper: RoomHelper? = null
    var listData = mutableListOf<RoomMemo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {

        val binding = ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {

        holder.setMemo(listData[position])
    }

    override fun getItemCount(): Int {

        return listData.size
    }


    inner class RoomViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

        var mRoomMemo: RoomMemo? = null

        init {
            binding.buttonDelete.setOnClickListener {
                helper?.roomMemoDao()?.delete(mRoomMemo!!)
                listData.remove(mRoomMemo)
                notifyDataSetChanged()
            }
        }

        fun setMemo(roomMemo: RoomMemo) {
            with(binding) {
                textNo.text = "${roomMemo.no}"
                textContent.text = roomMemo.content
                val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
                textDatetime.text = sdf.format(roomMemo.datetime)
            }
        }

    }

}