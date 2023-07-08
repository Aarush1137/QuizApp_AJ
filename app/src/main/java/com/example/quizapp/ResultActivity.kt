package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.contentcapture.ContentCaptureSession
import android.widget.Button
import android.widget.TextView

@Suppress("DEPRECATION")
class ResultActivity : AppCompatActivity() {
    private lateinit var tv_name: TextView
    private lateinit var tv_score: TextView
    private lateinit var btn_finish: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        tv_name=findViewById(R.id.tv_name)
        tv_score=findViewById(R.id.tv_score)
        btn_finish=findViewById(R.id.btn_finish)

        val username=intent.getStringExtra(Constants.USER_NAME)
        tv_name.text=username

        val correctAns=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQues=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)


        //Display final score
        tv_score.text="Your score is $correctAns out of $totalQues"

        btn_finish.setOnClickListener {

            val intent= Intent(this, ButtonSelectActivity::class.java)
            intent.putExtra(Constants.SCORE,correctAns.toString())
            startActivity(intent)
            finish()
        }

    }
}