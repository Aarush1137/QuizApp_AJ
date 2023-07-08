package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import kotlin.random.Random
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int=1
    private var mQuestionsList:ArrayList<Questions>?=null
    private var mNewQuestionsList:ArrayList<Questions>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers=0
    private var mUserName:String?="null"

    private lateinit var mScrollView : ScrollView
    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var btn_submit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName=intent.getStringExtra(Constants.USER_NAME)

        mNewQuestionsList=Constants.getQuestions()

        tv_option_one=findViewById(R.id.tv_option_one)
        tv_option_two=findViewById(R.id.tv_option_two)
        tv_option_three=findViewById(R.id.tv_option_three)
        tv_option_four=findViewById(R.id.tv_option_four)
        btn_submit=findViewById(R.id.btn_submit)
        mScrollView=findViewById(R.id.scrView_questionsView)

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }
    @SuppressLint("Range")
    private fun setQuestion(){

        var list = ArrayList<Int>()
        for (i in 1..6) {
            val randomIndex = Random.nextInt(mNewQuestionsList!!.size)
            list.add(randomIndex)
        }
        var newList=ArrayList<Questions>()

        for(i in list){
            newList.add(mNewQuestionsList!![i])
        }
        mQuestionsList=newList

        val question= mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition==mQuestionsList!!.size)
        {
            btn_submit.text="Finish"
        }
        else{ btn_submit.text="Submit"}
        val progressBar:ProgressBar=findViewById(R.id.progressBar)
        val tv_progress:TextView=findViewById(R.id.tv_progress)

        progressBar.progress=mCurrentPosition
        tv_progress.text="$mCurrentPosition"+"/"+progressBar.max

        val tv_question=findViewById<TextView>(R.id.tv_question)
        val iv_image=findViewById<ImageView>(R.id.iv_image)

        tv_question.text=question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
        //mScrollView.setBackgroundColor(Integer.parseInt(question.color.replaceFirst("#", ""), 16))
        mScrollView.setBackgroundColor(Color.parseColor(question.color))
    }

    //Setup layout template
    private fun defaultOptionsView(){
        val options=ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    //Enable option selector, keep score track
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one->{ selectedOptionView(tv_option_one,1)}
            R.id.tv_option_two->{ selectedOptionView(tv_option_two,2)}
            R.id.tv_option_three->{ selectedOptionView(tv_option_three,3)}
            R.id.tv_option_four->{ selectedOptionView(tv_option_four,4)}

            R.id.btn_submit->{
             if(mSelectedOptionPosition==0)
             {
                 mCurrentPosition++
                 when{
                     mCurrentPosition<=mQuestionsList!!.size ->{ setQuestion()}
                     else->{
                         val intent =Intent(this, ResultActivity::class.java)
                         intent.putExtra(Constants.USER_NAME,mUserName)
                         intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                         intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                         startActivity(intent)
                         finish()
                     }
                 }
             }else{
                 val question=mQuestionsList?.get(mCurrentPosition-1)
                 if(question!!.correctAnswer!=mSelectedOptionPosition){
                     answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                 }else{mCorrectAnswers++}
                     answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
             if(mCurrentPosition==mQuestionsList!!.size){
                 btn_submit.text="Finish"
             }else{
                 btn_submit.text="Go to next question"
             }
                 mSelectedOptionPosition=0
             }
            }
        }
    }

    //Set options background
    private fun answerView(answer: Int, drawableView:Int){
        when(answer){
            1 ->{tv_option_one.background=ContextCompat.getDrawable(this,drawableView) }
            2-> {tv_option_two.background=ContextCompat.getDrawable(this,drawableView)}
            3->{tv_option_three.background=ContextCompat.getDrawable(this,drawableView)}
            4->{tv_option_four.background=ContextCompat.getDrawable(this,drawableView)}
        }
    }

    //Set Green/Red colour based on choice
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionsView()
        mSelectedOptionPosition=selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}