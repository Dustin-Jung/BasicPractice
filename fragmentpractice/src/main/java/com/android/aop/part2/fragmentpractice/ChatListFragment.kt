package com.android.aop.part2.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aop.part2.fragmentpractice.databinding.FragmentChatlistBinding



class ChatListFragment: Fragment(R.layout.fragment_chatlist) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChatlistBinding.inflate(inflater, container, false)
        return binding.root
    }
}