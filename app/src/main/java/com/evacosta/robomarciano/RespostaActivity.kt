package com.evacosta.robomarciano
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RespostaActivity : AppCompatActivity(R.layout.activity_resposta) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        val answer = intent.getStringExtra("answer")
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val txtResposta = findViewById<TextView>(R.id.textResposta)

        txtResposta.text = answer

        btnVoltar.setOnClickListener(View.OnClickListener {
            intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }

            startActivity(intent)
        })
    }
}