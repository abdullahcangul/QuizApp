package com.example.quizapp.ui.add

import android.content.Context
import android.os.AsyncTask
import com.example.quizapp.data.QuestionDao
import com.example.quizapp.data.QuestionDb
import com.example.quizapp.model.Question

class AddQuestionRepository(context: Context) {
    private val db by lazy { QuestionDb.getInstance(context) }
    private val dao: QuestionDao by lazy { db.questionDao() }

    fun insertQuestion(question: Question) {
        InsertAsyncTask(dao).execute(question)
    }

    private class InsertAsyncTask(val dao: QuestionDao): AsyncTask<Question, Void, Void>() {
        override fun doInBackground(vararg params: Question?): Void? {
            dao.addQuestion(params[0]!!)
            return null
        }

    }

}