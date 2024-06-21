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
    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasena: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //iniciar componentes
        iniciarComponentes()
        eventoClic()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun iniciarComponentes() {
        txtUsuario = findViewById(R.id.txtuser)
        txtContrasena = findViewById(R.id.txtpass)
        btnSalir = findViewById(R.id.btnCerrar)
        btnIngresar = findViewById(R.id.btnEntrar)
    }

    private fun eventoClic() {
        btnIngresar.setOnClickListener(View.OnClickListener {
            val usuario: String = getString(R.string.Usuario)
            val pass: String = getString(R.string.Pass)
            val nombre: String = getString(R.string.Nombre)

            if (txtUsuario.text.toString() == usuario && txtContrasena.text.toString() == pass) {
                val intent = Intent(this, OperacionesActivity::class.java)
                intent.putExtra("nombre", nombre)
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
