package com.example.projectt

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.projectt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.name = "1"
        var currentNumber = binding.name.toString()

        val button1: Button = findViewById(R.id.button1)

        button1.setOnClickListener {
            Toast.makeText(this, "soobsheniye", Toast.LENGTH_SHORT).show()
        }

        val button2: Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            currentNumber = (currentNumber.toInt() + 1).toString()
            binding.name = currentNumber
        }

        val button3: Button = findViewById(R.id.button3)

        button3.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)


            randomIntent.putExtra("currentNumberSec", currentNumber)


            startActivity(randomIntent)
        }

        val button4: Button = findViewById(R.id.button4)
        val changableText: TextView = findViewById(R.id.editTextText)

        button4.setOnClickListener {
            currentNumber = changableText.text.toString()
            binding.name =  currentNumber

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {

        var currentNumber = findViewById<TextView>(R.id.textView).text


        outState?.run {
            putString("KEY", currentNumber.toString())
        }
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show()
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        findViewById<TextView>(R.id.textView).text = savedInstanceState?.getString("KEY")
        Toast.makeText(this, "restored", Toast.LENGTH_SHORT).show()

    }

}