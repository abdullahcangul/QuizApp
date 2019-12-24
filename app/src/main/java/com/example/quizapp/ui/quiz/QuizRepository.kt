package com.example.quizapp.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.quizapp.data.QuestionDao
import com.example.quizapp.data.QuestionDb
import com.example.quizapp.model.Question

class QuizRepository(context: Context) {
    private val db:QuestionDb by lazy { QuestionDb.getInstance(context) }
    private val dao:QuestionDao by lazy { db.questionDao() }

    fun getAllQuestions(): LiveData<List<Question>> =
    dao.getQuestions()

}