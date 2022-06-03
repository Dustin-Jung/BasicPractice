package com.android.aop.part2.sharedpreferencespractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.aop.part2.sharedpreferencespractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val shared = getSharedPreferences("파일명", Context.MODE_PRIVATE)
        val first_open = shared.getBoolean("KEY_FIRST_OPEN",false)
        if (first_open) {
            binding.hi.visibility = View.GONE
        }
        val editor = shared.edit()
        editor.putBoolean("KEY_FIRST_OPEN", true)
        editor.commit()
    }

}
