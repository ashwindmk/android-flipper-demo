package com.ashwin.flipperdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val file = findViewById<EditText>(R.id.file_name_edit_text).text.toString()
            val key = findViewById<EditText>(R.id.key_edit_text).text.toString()
            val value = findViewById<EditText>(R.id.value_edit_text).text.toString()
            save(file, key, value)
        }
    }

    private fun save(file: String, key: String, value: String) {
        val sharedPrefs = getSharedPreferences(file, Context.MODE_PRIVATE)
        sharedPrefs.edit().putString(key, value).apply()
    }
}
