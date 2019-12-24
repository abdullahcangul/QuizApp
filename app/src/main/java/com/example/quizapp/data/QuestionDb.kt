package com.example.quizapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

import com.example.quizapp.model.Question

@Database(entities = arrayOf(Question::class), version = 1)
abstract class QuestionDb: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile
        var INSTANCE: QuestionDb? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDb::class.java,
                    "question_db"
                )
                    .addCallback(roomDbCallback)
                    .build()
            }

            return INSTANCE as QuestionDb
        }

        private val roomDbCallback = object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }
        }


        class PopulateAsyncTask(private val db: QuestionDb?): AsyncTask<Void, Void, Void>() {

            private val dao: QuestionDao? by lazy { db?.questionDao() }

            override fun doInBackground(vararg params: Void?): Void? {
                var question = Question(
                    question = "Android uygulama yazabilmek için hangi programlama dilini bilmeniz gerekir?",
                    optionA = "Java",
                    optionB = "Kotlin",
                    optionC = "Hepsi",
                    answer = "Hepsi"
                )
                dao?.addQuestion(question)

                question = Question(
                    question = "Activity ilk başlağından hangi metod çalışır?",
                    optionA = "onStart",
                    optionB = "onCreate",
                    optionC = "onResume",
                    answer = "onCreate"
                )
                dao?.addQuestion(question)

                question = Question(
                    question = "Aşağıdakilerden hangisi Androidde kullanılan veritabanı türüdür?",
                    optionA = "Oracle",
                    optionB = "MySql",
                    optionC = "SQLite",
                    answer = "SQLite"
                )
                dao?.addQuestion(question)

                return null
            }

        }
    }

}
