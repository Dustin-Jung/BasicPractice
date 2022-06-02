package com.android.aop.part2.bmicheck

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.aop.part2.bmicheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.resultButton.setOnClickListener {

            if (binding.heightEditText.text.isEmpty() || binding.weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

                val height: Int = binding.heightEditText.text.toString().toInt()
                val weight: Int = binding.weightEditText.text.toString().toInt()

                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("height", height)
                intent.putExtra("weight", weight)

                startActivity(intent)

            }
    }
}
