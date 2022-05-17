package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import java.text.DecimalFormat
import java.util.*


class MainActivity : AppCompatActivity(){
    lateinit var tts : TextToSpeech
    lateinit var resultado : TextView
    lateinit var ttsButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado = findViewById(R.id.resultado) as TextView
        val valor : TextInputEditText = findViewById(R.id.valor) as TextInputEditText
        val qtdePessoas : TextInputEditText = findViewById<TextInputEditText>(R.id.qtdePessoas)

        var currentValor : Double = 0.0
        var currentQtdePessoas : Int = 0

        tts = TextToSpeech(this, TextToSpeech.OnInitListener { i ->
            if (i == TextToSpeech.SUCCESS) {
                Log.e("TTS", "SUCESSO")
                tts!!.setLanguage(Locale("pt","BR"))
            }
        })


        ttsButton = findViewById(R.id.ttsButton)
        ttsButton.setOnClickListener{
            var reais = resultado.text.toString().substring(2,resultado.text.toString().length-3)
            var centavos = resultado.text.toString().substring(resultado.text.toString().length-2)
            speakOut("A conta deu" + reais + "reais e " + centavos + " centavos para cada.")
        }

        valor.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var text : String = "" + s
                if(text == "")
                    text = "0.0"
                currentValor = text.toDouble()
                val valorFinal =  DecimalFormat("0.00").format(divideCheck(currentValor, currentQtdePessoas))
                resultado.text = valorFinal
            }

        })

        qtdePessoas.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                var text : String = "" + s
                if(text == "")
                    text = "0"
                currentQtdePessoas = text.toInt()
                val valorFinal =  DecimalFormat("0.00").format(divideCheck(currentValor, currentQtdePessoas))
                resultado.text = valorFinal
            }
        })

        val shareButton: Button = findViewById(R.id.shareButton)
        shareButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val sharingIntent = Intent(Intent.ACTION_SEND)
                sharingIntent.type = "text/plain"
                val shareBody = "Compartilhe o resultado da conta com seus amigos."
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Conta")
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
                startActivity(Intent.createChooser(sharingIntent, "Compartilhe através"))
            }
        })
    }

    fun divideCheck(valor: Double, qtdePessoas: Int): Double {
        var y : Int = 0
        if (qtdePessoas == 0)
            y = 1
        else
            y = qtdePessoas
        val x : Double = valor/y
        return x
    }


    fun speakOut(text: String){
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH,null,"")
    }

    override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}