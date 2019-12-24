package com.example.quizapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.quizapp.model.Question

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions")
    fun getQuestions():LiveData<List<Question>>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun addQuestion(question: Question)

    @Query("DELETE FROM questions")
    fun deleteQuestions()
}