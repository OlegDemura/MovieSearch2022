package com.bignerdranch.android.moviesearch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bignerdranch.android.moviesearch.data.Data

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TITLE1 = "TITLE1"
        private const val TITLE2 = "TITLE2"
        private const val TITLE3 = "TITLE3"
        const val COMMENT = "COMMENT"
        const val CHECK_BOX = "CHECK_BOX"
        const val FILM = "FILM"
    }

    lateinit var title1: TextView
    lateinit var title2: TextView
    lateinit var title3: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView1 = findViewById<ImageView>(R.id.image1)
        val imageView2 = findViewById<ImageView>(R.id.image2)
        val imageView3 = findViewById<ImageView>(R.id.image3)

        title1 = findViewById(R.id.title1)
        title2 = findViewById(R.id.title2)
        title3 = findViewById(R.id.title3)

        savedInstanceState?.let {
            title1.setTextColor(it.getInt(TITLE1))
            title2.setTextColor(it.getInt(TITLE2))
            title3.setTextColor(it.getInt(TITLE3))
        }

        val description1 = findViewById<TextView>(R.id.description1)
        val description2 = findViewById<TextView>(R.id.description2)
        val description3 = findViewById<TextView>(R.id.description3)

        val button1 = findViewById<Button>(R.id.detailsButton1)
        val button2 = findViewById<Button>(R.id.detailsButton2)
        val button3 = findViewById<Button>(R.id.detailsButton3)

        val data = Data().list

        imageView1.setImageResource(data[0].image)
        imageView2.setImageResource(data[1].image)
        imageView3.setImageResource(data[2].image)

        title1.text = data[0].title
        title2.text = data[1].title
        title3.text = data[2].title

        description1.text = data[0].description
        description2.text = data[0].description
        description3.text = data[0].description

        button1.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(FILM, data[0])
            changeColorTitle(title1)
            startActivityForResult(intent, 0)
        }

        button2.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(FILM, data[1])
            changeColorTitle(title2)
            startActivityForResult(intent, 0)
        }

        button3.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(FILM, data[2])
            changeColorTitle(title3)
            startActivityForResult(intent, 0)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TITLE1, title1.textColors.defaultColor)
        outState.putInt(TITLE2, title2.textColors.defaultColor)
        outState.putInt(TITLE3, title3.textColors.defaultColor)
    }


    fun changeColorTitle(textView: TextView) {
        textView.setTextColor(ContextCompat.getColor(this, R.color.teal_200))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return
        }

        if (requestCode == 0) {
            val string = data?.getCharSequenceExtra(COMMENT)?.toString()
            val checkBox = data?.getBooleanExtra(CHECK_BOX, false)
            string?.let {
                Toast.makeText(
                    this, "$it " +
                            if (checkBox == true) "Like" else "",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if (checkBox == true) {
                Toast.makeText(
                    this, "Like",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}