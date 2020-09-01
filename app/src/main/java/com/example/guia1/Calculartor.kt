package com.example.guia1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Calculartor : AppCompatActivity() {
    lateinit var tvOperacion:TextView
    lateinit var tvResultado:TextView
    lateinit var btnAc:Button
    lateinit var btnDel:Button
    lateinit var btnSumar:Button
    lateinit var btnRestar:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var btnMultiplicar:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btnDividir:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btnIgual:Button
    lateinit var btn0:Button

    private var auxNumero1:String = ""
    private var auxNumero2:String = ""
    private var auxSigno:String = ""
    private var auxNumeroTotal:String = ""

    private var number1:Int = 0
    private var number2:Int = 0
    private var total:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculartor)

        tvOperacion = findViewById(R.id.tvOperacion)
        tvResultado = findViewById(R.id.tvResultado)
        btnAc = findViewById(R.id.btnAc)
        btnDel = findViewById(R.id.btnDel)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btnMultiplicar = findViewById(R.id.btnMultiplar)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btnDividir = findViewById(R.id.btnDivision)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btnIgual = findViewById(R.id.btnIgual)
        btn0 = findViewById(R.id.btn0)

        btn0.setOnClickListener(clickListener)
        btn1.setOnClickListener(clickListener)
        btn2.setOnClickListener(clickListener)
        btn3.setOnClickListener(clickListener)
        btn4.setOnClickListener(clickListener)
        btn5.setOnClickListener(clickListener)
        btn6.setOnClickListener(clickListener)
        btn7.setOnClickListener(clickListener)
        btn8.setOnClickListener(clickListener)
        btn9.setOnClickListener(clickListener)
        btnSumar.setOnClickListener(clickListener)
        btnRestar.setOnClickListener(clickListener)
        btnMultiplicar.setOnClickListener(clickListener)
        btnDividir.setOnClickListener(clickListener)
        btnIgual.setOnClickListener(clickListener)
        btnAc.setOnClickListener(clickListener)
        btnDel.setOnClickListener(clickListener)
    }

    private val clickListener = View.OnClickListener { view ->
        when(view.id){
            R.id.btn0 -> setNumbers(0)
            R.id.btn1 -> setNumbers(1)
            R.id.btn2 -> setNumbers(2)
            R.id.btn3 -> setNumbers(3)
            R.id.btn4 -> setNumbers(4)
            R.id.btn5 -> setNumbers(5)
            R.id.btn6 -> setNumbers(6)
            R.id.btn7 -> setNumbers(7)
            R.id.btn8 -> setNumbers(8)
            R.id.btn9 -> setNumbers(9)

            R.id.btnSumar -> operateNumbers("+")
            R.id.btnRestar -> operateNumbers("-")
            R.id.btnMultiplar -> operateNumbers("*")
            R.id.btnDivision -> operateNumbers("/")
            R.id.btnIgual -> operateNumbers("=")
            R.id.btnAc -> resetDisplay()
            R.id.btnDel -> eraseNumber()
        }
    }
    private fun setNumbers(number:Int){
        var displayText = ""

        //assign number1 or number2
        if(auxSigno.isEmpty()){ //if there's still no sign
            number1 = (number1*10) + number //number1 will grow
            displayText = "$number1" //set display to number1
        }else{ //if there's already a sign
            number2 = (number2*10) + number //set number2, 'cause number1 is done
            displayText = "$number1$auxSigno$number2" //set display to the operation
        }

        //set displays
        tvResultado.text = displayText
    }
    private fun operateNumbers(sign:String){
        if(auxSigno.isNotEmpty()){ //if there's already a sign
            when(auxSigno){ //operate numbers and assign the value to number1
                "+" -> number1 += number2
                "-" -> number1 -= number2
                "*" -> number1 *= number2
                "/" -> number1 /= number2
            }
            number2 = 0 //reset number2 so it can take other values
        }
        auxSigno = sign //change/assign the sign
        var displayText:String = number1.toString() + if(auxSigno == "=") "" else auxSigno //if the sign is not =, concatenate sign
        tvResultado.text = displayText //set display to number1
    }
    private fun eraseNumber(){
        var text = ""
        var displayText = ""
        if(auxSigno.isEmpty()){
            text = number1.toString().substring(0, number1.toString().length-1)
            number1 = text.toInt()
            displayText = "$number1"
        }else{
            text = number2.toString().substring(0, number2.toString().length-1)
            number2 = text.toInt()
            displayText = "$number1$auxSigno$number2"
        }

         //set display to the operation
        tvResultado.text = displayText
    }
    private fun resetDisplay(){
        number1 = 0
        number2 = 0
        auxSigno = ""
        tvResultado.text = "0"
    }
}