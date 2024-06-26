package com.example.appcalculadora

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inUsuario: EditText
    private lateinit var inPassword: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Iniciar componente
        init()
        eventosClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        inUsuario = findViewById(R.id.txtuser)
        inPassword = findViewById(R.id.txtpass)
        btnIngresar = findViewById(R.id.btnEntrar)
        btnSalir = findViewById(R.id.btnCerrar)
    }

    private fun eventosClic() {
        btnIngresar.setOnClickListener(View.OnClickListener {
            val user: String = getString(R.string.Usuario)
            val password: String = getString(R.string.Pass)
            val name: String = getString(R.string.Nombre)

            if (inUsuario.text.toString() == user && inPassword.text.toString() == password) {
                val intent = Intent(this, operacionesactivity::class.java)
                intent.putExtra("nombre", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "El usuario o password no son correctos", Toast.LENGTH_SHORT).show()
            }
        })

        btnSalir.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}
