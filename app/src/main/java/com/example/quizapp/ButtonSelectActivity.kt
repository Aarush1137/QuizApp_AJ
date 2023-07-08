package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ButtonSelectActivity : AppCompatActivity() {

    private var mUserName:String?="null"
    private var mScore:String?="null"

    private lateinit var btn_start_game_2: Button
    private lateinit var btn_view_score: Button
    private lateinit var btn_back: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_select)

        mUserName=intent.getStringExtra(Constants.USER_NAME)
        mScore=intent.getStringExtra(Constants.SCORE)

        btn_start_game_2=findViewById(R.id.btn_start_2)
        btn_view_score=findViewById(R.id.btn_score)
        btn_back=findViewById(R.id.btn_back)

        //Start the game
        btn_start_game_2.setOnClickListener{
            val intent=Intent(this, QuizQuestionsActivity::class.java)
            intent.putExtra(Constants.USER_NAME, mUserName)
            startActivity(intent)
            finish()
        }

        //Back button to return to main screen
        btn_back.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //Display previous score
        btn_view_score.setOnClickListener{
            Toast.makeText(this,"Your previous score was: $mScore/6", Toast.LENGTH_SHORT).show()
        }
    }
}