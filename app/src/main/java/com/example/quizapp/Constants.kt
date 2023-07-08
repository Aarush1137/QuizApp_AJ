package com.example.quizapp

object Constants{

    const val USER_NAME:String="Username"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS: String="correct_Answers"
    const val SCORE: String = "score"


fun getQuestions(): ArrayList<Questions>{
        val questionList=ArrayList<Questions>()


//Question 1
    val que1= Questions(1,
        "What country does this flag belong to?",
    R.drawable.ic_flag_of_argentina,
        "Argentina",
        "Australia",
        "Armenia",
        "Austria",
        1,
        "#FFFFFF"
    )
    questionList.add(que1)

    //Question 2
    val que2= Questions(2,
        "What country does this flag belong to?",
        R.drawable.ic_flag_of_australia,
        "Belgium",
        "Australia",
        "Aruba",
        "Austria",
        2,
        "#FFFFFF"
    )
    questionList.add(que2)

//Question 3
    val que3= Questions(3,
        "Leopard Tanks are advanced battle tanks manufactured by",
        R.drawable.questionmark,
        "Germany",
        "China",
        "Russia",
        "United States",
        1,
        "#F5E6BE"
    )
    questionList.add(que3)


//Question 4
    val que4= Questions(4,
        "Which of the following country shares land border with Ukraine?",
        R.drawable.questionmark,
        "Germany",
        "Croatia",
        "Estonia",
        "Poland",
        4,
        "#F5E6BE"
    )
    questionList.add(que4)

    //Question 5
    val que5= Questions(5,
        "International Hockey World Cup 2023 is currently being played in",
        R.drawable.questionmark,
        "Australia",
        "England",
        "India",
        "Pakistan",
        3,
        "#F5C6BE"
    )
    questionList.add(que5)

//Question 6
    val que6= Questions(6,
        "Which country has won the International Hockey World Cup for a record four times?",
        R.drawable.questionmark,
        "Germany",
        "Holland",
        "India",
        "Pakistan",
        4,
        "#F5C6BE"
    )
    questionList.add(que6)

//Question 7
    val que7= Questions(7,
        "Kevin McCarthy became the speaker of the United States House of Representatives on 7 January 2023 in which round of the voting?",
        R.drawable.questionmark,
        "3rd",
        "5th",
        "10th",
        "15th",
        4,
        "#E4EDA1"
    )
    questionList.add(que7)

    //Question 8
    val que8= Questions(8,
        "Who is named as “Person of the Year 2022” by the Time Magazine?",
        R.drawable.questionmark,
        "Elon Musk",
        "Vladimir Putin",
        "Lionel Messi",
        "Volodymyr Zelensky",
        4,
        "#E4EDA1"
    )
    questionList.add(que8)

    //Question 9
    val que9= Questions(9,
        "The “Hundred Years’ War” was a series of armed conflicts between the kingdoms of",
        R.drawable.questionmark,
        "China and Japan",
            "England and France",
                "Canada and United States",
            "Spain and Italy",
                2,
        "#A1EDA1"
    )
    questionList.add(que9)

    //Question 10
    val que10= Questions(10,
        "Three Gorges Dam has world’s largest power station. It is located in",
        R.drawable.questionmark,
        "Canada",
        "China",
        "Russia",
        "United States",
        2,
        "#A1EDA1"
    )
    questionList.add(que10)

    val que11= Questions(11,
        "The total installed capacity of power station of the “Three Gorges Dam” in China is",
        R.drawable.questionmark,
        "10,500 MW" ,
                "14,500 MW" ,
                "18,500 MW" ,
                "22,500 MW",
        4,
        "#A1EAED"
    )
    questionList.add(que11)

    val que12= Questions(12,
        "The United States’ state of “Alaska” shares maritime border with Canada and",
        R.drawable.questionmark,
        "Mexico" ,
        "Iceland" ,
        "Greenland" ,
        "Russia",
        4,
        "#A1EAED"
    )
    questionList.add(que12)


    val que13= Questions(13,
        "The “Hawaii” state of the United States is located about 2000 miles from the US mainland in the",
        R.drawable.questionmark,
        "Atlantic ocean",
                "Pacific ocean",
                "Arctic ocean" ,
                "Mediterranean Sea",
        2,
        "#A1B3ED"
    )
    questionList.add(que13)

    val que14= Questions(14,
        "What is the name of the ocean that lies between Europe and the United States?",
        R.drawable.questionmark,
        "Atlantic ocean",
        "Pacific ocean",
        "Arctic ocean" ,
        "Mediterranean Sea",
        1,
        "#A1B3ED"
    )
    questionList.add(que14)

    val que15= Questions(15,
        "What height is known as “Death zone” where oxygen is insufficient for human life?",
        R.drawable.questionmark,
        "7500 meter",
        "8000 meter",
        "8500 meter" ,
        "9000 meter",
        2,
        "#EAB3F1"
    )
    questionList.add(que15)

    val que16= Questions(16,
        "By volume of water, the world’s largest freshwater lake is",
        R.drawable.questionmark,
        "Caspian Sea",
        "Lake Superior",
        "Lake Baikal" ,
        "Lake Lucerne",
        3,
        "#EAB3F1"
    )
    questionList.add(que16)

    val que17= Questions(17,
        "The International Olympic Committee (IOC) was founded by",
        R.drawable.questionmark,
        "Demetrios Vikelas",
        "Pierre de Coubertin",
        "Thomas Bach" ,
        "Juan Antonio Samaranch",
        2,
        "#9C9096"
    )
    questionList.add(que17)



    val que18= Questions(18,
        "The headquarters of International Olympic Committee (IOC) is located in",
        R.drawable.questionmark,
        "Berlin",
        "Luasanne",
        "London" ,
        "Zurich",
        2,
        "#9C9096"
    )
    questionList.add(que18)

    val que19= Questions(19,
        "Buddhism is world’s fourth-largest religion. It is believed to be originated in",
        R.drawable.questionmark,
        "China",
        "India",
        "Japan" ,
        "Thailand",
        2,
        "#CAC891"
    )
    questionList.add(que19)

    val que20= Questions(20,
        "“Angel Falls” is the world’s tallest waterfalls. It is located in",
        R.drawable.questionmark,
        "Argentina",
        "Canada",
        "Russia" ,
        "Venezuela",
        4,
        "#CAC891"
    )
    questionList.add(que20)



    return(questionList)

    }
}