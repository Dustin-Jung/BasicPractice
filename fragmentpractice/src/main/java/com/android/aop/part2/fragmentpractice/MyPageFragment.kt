package com.android.aop.part2.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.aop.part2.fragmentpractice.databinding.FragmentMypageBinding


class MyPageFragment: Fragment(R.layout.fragment_mypage) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }
}