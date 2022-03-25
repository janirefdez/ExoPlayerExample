package com.janirefernandez.exoplayerexample.player

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSource

class ExoPlayer(context: Context, url: String) {

    private var exoPlayer: ExoPlayer? = null

    fun onPause() {
        exoPlayer!!.playWhenReady = false
    }

    fun onStart() {
        exoPlayer!!.playWhenReady = true
    }

    fun onRelease() {
        exoPlayer!!.release()
    }

    fun getPlayer(): ExoPlayer {
        return exoPlayer!!
    }

    init {
        val mediaDataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(context)
        val mediaSource = ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(
            MediaItem.fromUri(url)
        )
        val mediaSourceFactory = DefaultMediaSourceFactory(mediaDataSourceFactory)
        exoPlayer = ExoPlayer.Builder(context)
            .setMediaSourceFactory(mediaSourceFactory)
            .build()
        exoPlayer!!.addMediaSource(mediaSource)
        exoPlayer!!.prepare()
    }

}