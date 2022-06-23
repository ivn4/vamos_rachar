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


class MainActivity : AppCompatActivity(), Observer, View.OnClickListener, TextWatcher {

    var contaModel: ContaModel? = null

    var tts : TextToSpeech? = null
    var valorTotalContaEditText : TextInputEditText? = null
    var qtdePessoasEditText : TextInputEditText? = null
    var valorDivididoContaTextView : TextView? = null
    var shareButton: Button? = null
    var ttsButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create a variable to represent ContaModel
        contaModel = ContaModel()
        contaModel!!.addObserver(this)

        // association of controllers with layout components
        valorTotalContaEditText = findViewById(R.id.valor)
        qtdePessoasEditText = findViewById(R.id.qtdePessoas)
        valorDivididoContaTextView = findViewById(R.id.resultado)
        shareButton = findViewById(R.id.shareButton)
        ttsButton = findViewById(R.id.ttsButton)

        valorTotalContaEditText?.addTextChangedListener(this)
        qtdePessoasEditText?.addTextChangedListener(this)
        shareButton?.setOnClickListener(this)
        ttsButton?.setOnClickListener(this)


        tts = TextToSpeech(this, TextToSpeech.OnInitListener { i ->
            if (i == TextToSpeech.SUCCESS) {
                Log.e("TTS", "SUCESSO")
                tts!!.setLanguage(Locale("pt","BR"))
            }
        })
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.shareButton -> shared()
            R.id.ttsButton -> ttsSpeaker()
        }
    }

    fun shared(){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Compartilhe o resultado da conta com seus amigos."
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Conta")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Compartilhe através"))
    }

    fun ttsSpeaker(){
        val resultado = valorDivididoContaTextView!!.text.toString()
        var reais = resultado.substring(0,resultado.length-3)
        var centavos = resultado.substring(resultado.length-2)
        speakOut("A conta deu " + reais + " reais e " + centavos + " centavos para cada.")
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

    override fun update(p0: Observable?, p1: Any?) {
        var valorFinal: Double = divideCheck(contaModel!!.getValueValorTotalConta(), contaModel!!.getValueQtdePessoas())
        contaModel!!.setValueValorDividido(valorFinal)
        valorDivididoContaTextView!!.text = DecimalFormat("0.00").format(contaModel!!.getValueValorDividido())
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        if(valorTotalContaEditText!!.hasFocus()){

        } else if(qtdePessoasEditText!!.hasFocus()) {

        } else {

        }
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        var valorFinal: Double = 0.0
        var text : String = "" + p0
        if(valorTotalContaEditText!!.hasFocus()){
            contaModel!!.setValueValorTotalConta(text.toDouble())
        } else if(qtdePessoasEditText!!.hasFocus()) {
            contaModel!!.setValueQtdePessoas(text.toInt())
        } else {

        }
    }

    override fun afterTextChanged(p0: Editable?) {
        var valorFinal: Double = divideCheck(contaModel!!.getValueValorTotalConta(), contaModel!!.getValueQtdePessoas())
        contaModel!!.setValueValorDividido(valorFinal)
        valorDivididoContaTextView!!.text = DecimalFormat("0.00").format(contaModel!!.getValueValorDividido())
    }

    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}