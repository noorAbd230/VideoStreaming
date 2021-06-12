package com.example.videostreamingapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_main.*
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {
     var player : SimpleExoPlayer ?= null
    lateinit var url : String
    var playWhenReady = true
    var currentWindow = 0
    var playBackPosition:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var video = intent.getStringExtra("video")
        when (video) {
            "one" -> {
                url = intent.getStringExtra("urlOne")!!
            }
            "two" -> {
                url = intent.getStringExtra("urlTwo")!!
            }
            "three" -> {
                url = intent.getStringExtra("urlThree")!!
            }
            "four" -> {
                url = intent.getStringExtra("urlFour")!!
            }
            else -> {
                print("not found")
            }
        }
    }

    fun initVideo(){
        player = ExoPlayerFactory.newSimpleInstance(this)
        playerView.player = player
        var uri = Uri.parse(url)
        var dataSourceFactory = DefaultDataSourceFactory(this,"exoplayer-codelab")
        var mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
        player!!.playWhenReady = playWhenReady
        player!!.seekTo(currentWindow,playBackPosition)
        player!!.prepare(mediaSource,false,true)
        val audioAttributes: AudioAttributes = AudioAttributes.Builder()
            .setUsage(C.USAGE_MEDIA)
            .setContentType(C.CONTENT_TYPE_MOVIE)
            .build()

        player!!.setAudioAttributes(audioAttributes, true)

    }

    fun releaseVideo(){
        if (player != null){
            playWhenReady = player!!.playWhenReady
            playBackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }

    override fun onPause() {
        super.onPause()
       releaseVideo()

    }

    override fun onResume() {
        super.onResume()
        if (player!=null) initVideo()
    }


    override fun onStop() {
        super.onStop()
        releaseVideo()
    }



}
