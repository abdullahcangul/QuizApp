package com.example.quizapp.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.quizapp.R
import com.example.quizapp.model.Question
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {


    private lateinit var viewModel: AddQuestionViewModel
    private lateinit var answer: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        viewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)

        prepareSpinner()

        btn_save.setOnClickListener {
            val question = question_edt.text.toString()
            val optionA = opt_a_edt.text.toString()
            val optionB = opt_b_edt.text.toString()
            val optionC = opt_c_edt.text.toString()

            viewModel.insert(
                Question(
                    question = question,
                    optionA = optionA,
                    optionB = optionB,
                    optionC = optionC,
                    answer = if(answer == "A") optionA else if(answer == "B") optionB else optionC
                )
            )

            Toast.makeText(this, "Ekleme başarılı", Toast.LENGTH_LONG).show()
        }
    }

    private fun prepareSpinner() {
        val optList = mutableListOf("A", "B","C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                answer = parent?.getItemAtPosition(position).toString()
            }

        }
    }

}
