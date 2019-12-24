package com.example.quizapp.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.R
import com.example.quizapp.util.Constants
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent.extras.let {
            val result=intent.extras?.getInt(Constants.EXTRA_RESULT)
            val listSize= intent.extras?.getInt(Constants.EXTRA_LIST_SIZE)

            result_tv.text="$listSize sorudan $result tanesini dogru bildiniz"
        }
    }
}
