package com.bignerdranch.android.moviesearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.moviesearch.MainActivity.Companion.CHECK_BOX
import com.bignerdranch.android.moviesearch.MainActivity.Companion.COMMENT
import com.bignerdranch.android.moviesearch.MainActivity.Companion.FILM
import com.bignerdranch.android.moviesearch.model.Film

private const val TAG = "DetailsActivity"

class DetailsActivity : AppCompatActivity() {

    var commentForResult: String? = null
    lateinit var comment: EditText
    lateinit var checkBox: CheckBox
    var checkBoxResult: Boolean = false
    lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val imageView = findViewById<ImageView>(R.id.imageView)
        title = findViewById(R.id.title)
        val description = findViewById<TextView>(R.id.description)
        comment = findViewById(R.id.comment)
        checkBox = findViewById(R.id.checkBoxLike)

        val parcelableExtra = intent.getParcelableExtra<Film>(FILM)
        parcelableExtra?.let {
            imageView.setImageResource(parcelableExtra.image)
            title.text = parcelableExtra.title
            description.text = parcelableExtra.description
        }

    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d(TAG, s.toString())
                commentForResult = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
            }

        }
        comment.addTextChangedListener(titleWatcher)


        checkBox.apply {
            setOnCheckedChangeListener { _, isChecked
                ->
                checkBoxResult = isChecked
            }
        }

    }

    override fun onBackPressed() {
        returnResultToMain(commentForResult, checkBoxResult)
        super.onBackPressed()
    }


    fun sendToMessage(view: android.view.View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.fromParts("sms", "", null)
        intent.putExtra("sms_body", "Пойдем в кино? Фильм: ${title.text}")

        startActivity(intent)
    }


    private fun returnResultToMain(comment: String?, checkBox: Boolean) {
        comment?.let { Log.d(TAG, it) }
        val data = Intent().apply {
            putExtra(COMMENT, comment)
            putExtra(CHECK_BOX, checkBox)
        }
        setResult(RESULT_OK, data)
    }
}