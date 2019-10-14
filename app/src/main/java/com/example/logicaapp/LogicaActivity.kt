package com.example.logicaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_logica.*
import java.lang.StringBuilder

class LogicaActivity : AppCompatActivity() {

    private val trueValue = "T"
    private val falseValue = "F"
    private var firstRowCorrectAnswer = "T"
    private var secondRowCorrectAnswer = "T"
    private var thirdRowCorrectAnswer = "T"
    private var fourthRowCorrectAnswer = "T"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica)
        initViews()

        submitBtn.setOnClickListener {
            calcateUserInput()
        }
    }

    private fun initViews() {
        setValues()
    }

    private fun setValues() {

        var valueArray = IntArray(8) { (0..1).random() }

        var finalArray = valueArray.map { value -> if(value == 0) falseValue else trueValue }

        cel1.text = finalArray[0]
        cel2.text = finalArray[1]
        cel3.text = finalArray[2]
        cel4.text = finalArray[3]
        cel5.text = finalArray[4]
        cel6.text = finalArray[5]
        cel7.text = finalArray[6]
        cel8.text = finalArray[7]
    }

    private fun calculateAnswers() {

        firstRowCorrectAnswer = if (cel1.text.toString() + cel2.text.toString() == "TT")  trueValue else falseValue
        secondRowCorrectAnswer = if (cel3.text.toString() + cel4.text.toString() == "TT")  trueValue else falseValue
        thirdRowCorrectAnswer = if (cel5.text.toString() + cel6.text.toString() == "TT")  trueValue else falseValue
        fourthRowCorrectAnswer = if (cel7.text.toString() + cel8.text.toString() == "TT")  trueValue else falseValue

    }

    private fun calcateUserInput() {

        calculateAnswers()

        if (answerFirstRow.text.toString().toUpperCase() == firstRowCorrectAnswer &&
            answerSecondRow.text.toString().toUpperCase() == secondRowCorrectAnswer &&
            answerThirdRow.text.toString().toUpperCase() == thirdRowCorrectAnswer &&
            answerFourthRow.text.toString().toUpperCase() == fourthRowCorrectAnswer
        ) {
            Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
        }

        answerFirstRow.text.clear()
        answerSecondRow.text.clear()
        answerThirdRow.text.clear()
        answerFourthRow.text.clear()

        setValues()


    }



}
