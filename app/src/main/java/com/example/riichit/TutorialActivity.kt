package com.example.riichit

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.riichit.Drawables.tutorial
import com.example.riichit.LocaleHelper.setLocale

class TutorialActivity : AppCompatActivity() {
    private val context = this
    private lateinit var ivScreen: ImageView
    private lateinit var tvTutorial: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        setLocale(context)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        supportActionBar?.hide()

        var currentSlide = 0

        ivScreen = findViewById(R.id.ivScreen)
        tvTutorial = findViewById(R.id.tvTutorial)
        val buttonLeft = findViewById<Button>(R.id.btnLeft)
        val buttonRight = findViewById<Button>(R.id.btnRight)

        buttonLeft.setOnClickListener {
            currentSlide -= 1
            draw(currentSlide)
        }
        buttonRight.setOnClickListener {
            currentSlide += 1
            draw(currentSlide)
        }

        draw(currentSlide)
    }

    private fun draw(slide: Int) {
        val const = tutorial.size / 2
        val tvMap = arrayOf(
            1,
            2,
            0,
            3,
            0,
            4,
            5,
            0,
            6,
            7,
            8,
            9,
            0,
            10,
            11,
            12,
            13,
            14,
            15,
            16,
            17,
            20,
            21,
            22,
            23
        )
        val ivMap = arrayOf(
            0,
            1 + const,
            1,
            2 + const,
            2,
            2 + const,
            3 + const,
            3,
            3 + const,
            4 + const,
            5 + const,
            5 + const,
            5,
            5 + const,
            5 + const,
            0,
            0,
            6 + const,
            6 + const,
            6 + const,
            0,
            7 + const,
            7 + const,
            0,
            0
        )
        if (slide < 0 || slide > tvMap.size - 1) {
            finish()
        } else {
            tvTutorial.text = context.getString(
                context.resources.getIdentifier(
                    "tutorial_${tvMap[slide]}",
                    "string",
                    context.packageName
                )
            )
            ivScreen.setImageResource(tutorial[ivMap[slide]])
        }
    }
}