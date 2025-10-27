package com.example.projectt

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import kotlin.getValue
import com.example.projectt.databinding.ActivitySecondBinding
import androidx.lifecycle.Observer

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivitySecondBinding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val model: SimpleViewModel by viewModels()

        val nameObserver = Observer<Int> { newName ->
            binding.textViewRandom.text = newName.toString()
        }

        model.randomNumber.observe(this, nameObserver)

            model.randomNumber.value = intent.getIntExtra("rand", 12)


    }
}