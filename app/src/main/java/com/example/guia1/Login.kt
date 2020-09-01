package com.example.guia1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val TAG_LOGIN_RESULT = "Resultado del login"

class Login : AppCompatActivity() {
    lateinit var txtError:TextView
    lateinit var etUsuario:EditText
    lateinit var etContrasena:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtError = findViewById(R.id.txtError)
        etUsuario = findViewById(R.id.etUsuario)
        etContrasena = findViewById(R.id.etContrasena)
    }

    fun login(view:View){
        txtError.text = ""
        var usuario = etUsuario.text.toString()
        var contrasena = etContrasena.text.toString()

        if((usuario == "mario.rivera" || usuario == "mario@gmail.com") && contrasena == "admin"){
            var parentIntent = Intent()
            parentIntent.putExtra(TAG_LOGIN_RESULT,"Bienvenido, $usuario")
            setResult(ID_ACTIVITY_LOGIN, parentIntent)
            finish()
        }else{
            txtError.text = "Credenciales incorrectas :("
        }
    }
}