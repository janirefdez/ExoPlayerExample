package com.janirefernandez.exoplayerexample.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.janirefernandez.exoplayerexample.Constants
import com.janirefernandez.exoplayerexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSound.setOnClickListener {
            val i = Intent(this@MainActivity, StyledPlayerActivity::class.java)
            i.putExtra(URL_EXTRA, Constants.SOUND_URL)
            startActivity(i)
        }

        binding.btnVideo.setOnClickListener {
            val i = Intent(this@MainActivity, StyledPlayerActivity::class.java)
            i.putExtra(URL_EXTRA, Constants.VIDEO_URL)
            startActivity(i)
        }

        binding.btnVideo2.setOnClickListener {
            val i = Intent(this@MainActivity, CustomPlayerActivity::class.java)
            i.putExtra(URL_EXTRA, Constants.VIDEO_URL)
            startActivity(i)
        }


    }

    companion object {
        const val URL_EXTRA = "url extra"
    }
}