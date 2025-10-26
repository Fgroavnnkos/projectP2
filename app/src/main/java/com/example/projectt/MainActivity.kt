package com.example.projectt

import android.annotation.SuppressLint
import android.content.Intent
import androidx.activity.viewModels
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.projectt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val model: SimpleViewModel by viewModels()

        val nameObserver = Observer<Int> { newName ->
            binding.textView.text = newName.toString()
        }

        model.currentNumber.observe(this, nameObserver)

        val button1 = binding.button1

        button1.setOnClickListener {
            Toast.makeText(this, "soobsheniye", Toast.LENGTH_SHORT).show()
        }

        val button2 = binding.button2

        button2.setOnClickListener {
            model.plusOne()
        }

        val button3 = binding.button3

        button3.setOnClickListener {
            val randomIntent = Intent(this, SecondActivity::class.java)

            val rand = model.currentNumber.value ?: 2
            model.randomNumber.value = (0..rand).random()
            randomIntent.putExtra("currentNumberSec")

            startActivity(randomIntent)
        }

        val button4 = binding.button4
        val changableText = binding.editTextText.text?.toString()?.toIntOrNull() ?: 21

        button4.setOnClickListener {
            model.currentNumber.value = changableText
        }

    }

}