package com.janirefernandez.exoplayerexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.janirefernandez.exoplayerexample.databinding.ActivityStyledPlayerViewBinding
import com.janirefernandez.exoplayerexample.player.ExoPlayer
import com.janirefernandez.exoplayerexample.ui.MainActivity.Companion.URL_EXTRA

class StyledPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStyledPlayerViewBinding
    private var exoPlayer: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStyledPlayerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        if (extras != null) {
            val url = extras.getString(URL_EXTRA)
            exoPlayer = ExoPlayer(this, url!!)
            binding.playerView.player = exoPlayer!!.getPlayer()
            binding.playerView.requestFocus()
        }
    }

    public override fun onResume() {
        super.onResume()
        exoPlayer?.onStart()
    }

    public override fun onPause() {
        super.onPause()
        exoPlayer?.onPause()
    }

    public override fun onDestroy() {
        super.onDestroy()
        exoPlayer?.onRelease()
    }
}