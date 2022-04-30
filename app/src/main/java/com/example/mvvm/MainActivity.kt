package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private lateinit var biding : AppCompatActivity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}