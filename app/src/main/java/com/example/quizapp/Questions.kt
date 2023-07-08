package com.example.quizapp

data class Questions(val id: Int,
    val question: String="",
                     val image: Int=0,
                        val optionOne: String="",
    val optionTwo: String="",
    val optionThree: String="",
    val optionFour: String="",
            val correctAnswer: Int = 0,
                     val color: String = ""
)