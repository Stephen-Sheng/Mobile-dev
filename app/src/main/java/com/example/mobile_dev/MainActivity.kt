package com.example.mobile_dev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_dev.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)

        val loginPageFragment = LoginPage()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, loginPageFragment)
            commit()
        }
    }
}