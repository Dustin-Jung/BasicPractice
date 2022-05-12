package com.android.aop.part2.loginpractice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.android.aop.part2.loginpractice.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    val binding by lazy { ActivityLoginBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.loginButton.setOnClickListener {
            val email = getInputEmail()
            val password = getInputPassword()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        finish()
                    } else {
                        Toast.makeText(
                            this, "로그인에 실패하였습니다. 이메일 또는 비밀번호를 확인해주세요",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
        }

        binding.signUpButton.setOnClickListener {
            val email = getInputEmail()
            val password = getInputPassword()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "회원가입에 성공하였습니다. 로그인 버튼을 눌러 로그인 해주세요",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else{
                        Toast.makeText(
                            this,
                            "이미 가입한 회원이거나, 회원가입에 실패하였습니다.",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
        }

    }

    private fun getInputEmail(): String {
        return binding.emailAddressEditText.text.toString()
    }

    private fun getInputPassword(): String {
        return binding.emailPasswordEditText.text.toString()
    }

    private fun initEmailAndPasswordEditText(){
         val emailEditText = binding.emailAddressEditText
         val passwordEditText = binding.emailPasswordEditText

        emailEditText.addTextChangedListener {
            val enable = emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()
            binding.loginButton.isEnabled = enable
            binding.signUpButton.isEnabled = enable
        }

        passwordEditText.addTextChangedListener {
            val enable = emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()
            binding.loginButton.isEnabled = enable
            binding.signUpButton.isEnabled = enable
        }
    }
}