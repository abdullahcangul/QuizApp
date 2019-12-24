package com.example.quizapp.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.Question

class QuizViewModel(application: Application):AndroidViewModel(application) {
    private val repository:QuizRepository by lazy { QuizRepository(application) }

    val allQuestion:LiveData<List<Question>> by lazy { repository.getAllQuestions() }
}