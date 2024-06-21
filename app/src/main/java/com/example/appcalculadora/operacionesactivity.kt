package com.example.appcalculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class operacionesactivity : AppCompatActivity() {
    private lateinit var txtusuario : TextView
    private lateinit var txtNum1 : EditText
    private lateinit var txtNum2 : EditText
    private lateinit var txtResultado : TextView

    private lateinit var btnsumar :Button
    private lateinit var btnrestar :Button
    private lateinit var btndividir :Button
    private lateinit var btnmultiplicar :Button

    private lateinit var btnCerrar : Button
    private lateinit var btnLimpiar : Button

    private lateinit var operaciones: Operaciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_operacionesactivity)

        iniciarcomponentes()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    public fun iniciarcomponentes(){

        txtusuario = findViewById(R.id.txtUsuario)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        txtResultado = findViewById(R.id.txtResultado)

        btnsumar = findViewById(R.id.btnsumar)
        btnrestar = findViewById(R.id.btnrestar)
        btndividir = findViewById(R.id.btndividir)
        btnmultiplicar = findViewById(R.id.btnmultiplicar)

        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val bundle: Bundle? = intent.extras
        txtusuario.text = bundle?.getString("nombre")
    }

    public fun validar() :Boolean{
        if(txtNum1.text.toString().contentEquals( "") || txtNum2.text.toString().contentEquals("")){
            return false
        } else return true

        
    }

}