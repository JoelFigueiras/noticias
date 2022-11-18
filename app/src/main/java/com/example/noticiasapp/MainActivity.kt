package com.example.noticiasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val fragment = articlesFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }

    }
}