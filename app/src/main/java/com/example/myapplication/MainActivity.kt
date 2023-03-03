package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    lateinit var send_text: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<View>(R.id.btnStartAnotherActivity)
         send_text = findViewById(R.id.send_text_id)
        button.setOnClickListener {
            val str = send_text.text.toString()
            val intent = Intent(this, AnotherActivity::class.java)
            // start your next activity
            intent.putExtra("message_key",str)
            startActivity(intent)
        }
    }
}