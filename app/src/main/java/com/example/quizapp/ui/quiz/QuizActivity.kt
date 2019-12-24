package com.example.quizapp.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.quizapp.R
import com.example.quizapp.model.Question
import com.example.quizapp.ui.result.ResultActivity
import com.example.quizapp.util.Constants
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    private lateinit var viewModel: QuizViewModel
    private var questionList:List<Question> =arrayListOf()
    private var qindex:Int=0
    private var score:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel=ViewModelProviders.of(this).get(QuizViewModel::class.java)

        viewModel.allQuestion.observe(this,Observer{
            if (it.isNotEmpty()){
                questionList=it

                setViews()

                next_btn.setOnClickListener {

                    val answer=findViewById<Chip>(chip_gruop.checkedChipId)
                    chip_gruop.clearCheck()

                    checkAnswer(answer)
                    qindex++


                    if(qindex < questionList.size){ setViews()}
                    else{
                       val intent=Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.EXTRA_RESULT,score)
                        intent.putExtra(Constants.EXTRA_LIST_SIZE,questionList.size)
                        startActivity(intent)
                        finish()//geriye dönmeyi engeller

                    }

                }

            }
        })


    }

    private fun checkAnswer(answer:Chip){
        if(questionList[qindex].answer==answer.text){
            Toast.makeText(this,"Dogru cevap",Toast.LENGTH_LONG).show()
            score++
        }else{
            Toast.makeText(this,"Yanlış cevap dogrusu:${questionList[qindex].answer}",Toast.LENGTH_LONG).show()

        }
    }

    private fun setViews(){
        question_tv.text=questionList[qindex].question
        option_a_chip.text=questionList[qindex].optionA
        option_b_chip.text=questionList[qindex].optionB
        option_c_chip.text=questionList[qindex].optionC
    }
}
