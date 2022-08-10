package com.example.detectarconexionandroidkotlin

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoConexion = findViewById<TextView>(R.id.mensaje)

        Thread(Runnable {

            while (true) {

                var textoInicial = "No Tienes Conexión"

                val sc = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

                val redInfo = sc.allNetworkInfo

                for (ir in redInfo) {

                    if(ir.typeName.equals("WIFI", ignoreCase = true))
                        if(ir.isConnected) textoInicial = "Conectado con WiFi"

                    if(ir.typeName.equals("MOBILE", ignoreCase = true))
                        if(ir.isConnected) textoInicial = "Conectado con Datos Móviles"

                }

                runOnUiThread {
                    textoConexion.text = textoInicial
                }

            }

        }).start()

    }
}