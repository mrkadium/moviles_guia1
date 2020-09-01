package com.example.guia1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

const val ID_ACTIVITY_LOGIN = 1

class MainActivity : AppCompatActivity() {
    lateinit var tvBienvenida:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvBienvenida = findViewById(R.id.tvBienvienida)
    }
    fun btncalculadoraOnclick(view: View){
        var intent = Intent(this, Calculartor::class.java)
        startActivity(intent)
    }
    fun btnLoginOnclick(view: View){
        var intent = Intent(this, Login::class.java)
        startActivityForResult(intent, ID_ACTIVITY_LOGIN)
    }
    fun btnInfoOnclick(view: View){
        var intent = Intent(this, Information::class.java)
        startActivity(intent)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            ID_ACTIVITY_LOGIN -> {
                tvBienvenida.text = data?.getStringExtra(TAG_LOGIN_RESULT)
                Toast.makeText(this, "Datos correctos :)", Toast.LENGTH_SHORT)
            }
        }
    }
}