package com.example.quizapp.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.R
import com.example.quizapp.ui.add.AddActivity
import com.example.quizapp.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        start_quiz_btn.setOnClickListener {
            startActivity(Intent(this,QuizActivity::class.java))
            finish()
        }

        add_quiestion_btn.setOnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        }
    }
}
