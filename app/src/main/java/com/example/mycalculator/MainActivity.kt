package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var editTextAnswer: EditText
    private lateinit var buttonsNum: MutableList<Button>
    private lateinit var buttonsSign: MutableList<Button>
    private lateinit var buAC: Button
    private lateinit var buEqual: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        editTextAnswer = findViewById(R.id.editTextAnswer)

        buAC = findViewById(R.id.buAC)
        buAC.setOnClickListener {
            editText.setText("0")
            editTextAnswer.setText("")
        }

        buEqual = findViewById(R.id.buEqual)
        buEqual.setOnClickListener {
            editText.text = editTextAnswer.text
            editTextAnswer.setText("")
        }

        buttonsNum = mutableListOf(
            findViewById(R.id.bu1), findViewById(R.id.bu2), findViewById(R.id.bu3),
            findViewById(R.id.bu4), findViewById(R.id.bu5), findViewById(R.id.bu6),
            findViewById(R.id.bu7), findViewById(R.id.bu8), findViewById(R.id.bu9),
            findViewById(R.id.bu0),
        )
        buttonsNum.map{
            val t = it.text.toString()
            it.setOnClickListener {
                editText.setText(editText.text.toString()+t)
                editTextAnswer.setText(solveStr(editText.text.toString()))
        }}

        buttonsSign = mutableListOf(
            findViewById(R.id.buBracketsOpen), findViewById(R.id.buBracketsClose),
            findViewById(R.id.buDivide), findViewById(R.id.buMultiply),
            findViewById(R.id.buMinus), findViewById(R.id.buPlus),
            findViewById(R.id.buPercent), findViewById(R.id.buDot),
        )
        buttonsSign.map{
            val t = it.text.toString()
            it.setOnClickListener {
                editText.setText(editText.text.toString()+t)
                editTextAnswer.setText("")
            }}

        //*/
    }

    var signals = listOf("+","-","(",")","%","/","*")
    fun solveStr(str: String): String {
        if (signals.filter { it !in str }.size == signals.size)
            return str

        return ""
    }
    /**
     *

     *
     */
}