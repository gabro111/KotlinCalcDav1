package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {


    private lateinit var resultTextView: TextView;
    private lateinit var equalsButton: Button;
    private var opernad:Double = 0.0;
    private var operation:String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView);
        equalsButton = findViewById(R.id.equalButton);
        equalsButton.setOnClickListener{

            val secondOpernadText = resultTextView.text.toString();
            var  secondOperand:Double = 0.0;

            if(!secondOpernadText.isEmpty()){
                secondOperand = secondOpernadText.toDouble();
            }

            when(operation){
                "+" -> resultTextView.text = (opernad + secondOperand).toString();
                "-" -> resultTextView.text = (opernad - secondOperand).toString();
                "*" -> resultTextView.text = (opernad * secondOperand).toString();
                "/" -> resultTextView.text = (opernad / secondOperand).toString();
            }


        }

    }

    fun numberClick(view: View) {


        if(view is Button){
            val number :String = view.text.toString();
            var result:String = resultTextView.text.toString();
            if(result == "0"){
                result = "";
            }
            resultTextView.text = result + number;
        }
    }
    fun operationClick(view:View){
        if(view is Button){
            if(!resultTextView.text.toString().isEmpty()){
                opernad = resultTextView.text.toString().toDouble();
            }
            resultTextView.text ="";
            operation= view.text.toString();



        }
    }
    fun secondaryOperationClick(view:View){

        var num:Double = resultTextView.text.toString().toDouble();
        if(view is Button) {
            if(!resultTextView.text.toString().isEmpty()) {
                when (view.text) {
                    "+/-" -> resultTextView.text = (num * -1).toString();
                    "%" -> resultTextView.text = (num / 100).toString();
                    "√" -> resultTextView.text = (sqrt(num)).toString();
                    "C" -> resultTextView.text = "";
                    "." -> resultTextView.text = if(!resultTextView.text.toString().contains('.')) resultTextView.text.toString()+"." else resultTextView.text;
                }
            }
        }
    }
}