package com.example.videostreamingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)

        videoOne.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/eternal-delight-276016.appspot.com/o/videos%2Fyt1s.com%20-%20Idina%20Menzel%20AURORA%20%20Into%20the%20Unknown%20From%20Frozen%202.mp4?alt=media&token=43edeb22-c358-49e1-ba2a-aaebaed2e6bb")
            startActivity(i)
        }

        videoTwo.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/eternal-delight-276016.appspot.com/o/videos%2Fyt1s.com%20-%20FROZEN%20%20Let%20It%20Go%20from%20Disneys%20FROZEN%20%20performed%20by%20Idina%20Menzel%20%20Official%20Disney%20UK.mp4?alt=media&token=9388b28a-2257-4089-8814-aa2868b743c1")
            startActivity(i)
        }

        videoThree.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("url","https://firebasestorage.googleapis.com/v0/b/eternal-delight-276016.appspot.com/o/videos%2Fyt1s.com%20-%20Do%20You%20Want%20to%20Build%20a%20Snowman%20From%20FrozenSingAlong.mp4?alt=media&token=aee7c1b0-b8e3-44da-b05c-b9c9ba30fc77")
            startActivity(i)
        }

        videoFour.setOnClickListener {
            var i = Intent(this,MainActivity::class.java)
            i.putExtra("url","https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
            startActivity(i)
        }
    }
}