package com.evacosta.robomarciano

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import robo.MarcianoPremiumRobot
import robo.OperationType
import robo.UserAction

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var btnEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById<EditText>(R.id.editText)
        btnEnviar = findViewById<Button>(R.id.btnEnviar)

        inputText.requestFocus()
        btnEnviar.setOnClickListener {
            val mensagem = inputText.text.toString()
            obtemMensagem(mensagem)
        }
    }


    fun extractOperands(input: String): DoubleArray {
        // Extrair os operandos numéricos da entrada
        val operands = input.split(Regex("\\s+")).mapNotNull { it.toDoubleOrNull() }.toDoubleArray()
        return operands
    }

    fun identifyOperationType(input: String): OperationType? {
        return when {
            "some" in input -> OperationType.ADD
            "subtraia" in input -> OperationType.SUBTRACT
            "multiplique" in input -> OperationType.MULTIPLY
            "divida" in input -> OperationType.DIVIDE
            else -> null
        }
    }

    private fun obtemMensagem(message: String) {
        val userAction = object : UserAction {
            override fun performAction():String {
                return "Definição de programador: A pessoa que resolve um problema que você nem sabe que tem , de uma forma que você não entende!"
            }
        }
        val robot = MarcianoPremiumRobot(userAction)

        val intent: Intent

        if (message.equals("agir", ignoreCase = true)) {
            val msg = userAction.performAction()
            intent = Intent(this, RespostaActivity::class.java).apply {

                putExtra("answer", "É pra já!! $msg")
            }
        }
        else if (identifyOperationType(message) != null) {
            val operationType = identifyOperationType(message)!!
            val operands = extractOperands(message)

            if (operands.size >= 2) {
                val resposta = robot.respond(operationType, *operands)
                intent = Intent(this, RespostaActivity::class.java).apply {
                    putExtra("answer", resposta)
                }
            } else {
                intent = Intent(this, RespostaActivity::class.java).apply {
                    putExtra("answer", "Operandos insuficientes para a operação.")
                }
            }
        }else {
            intent = Intent(this, RespostaActivity::class.java).apply {

                putExtra("answer", robot.respond(message))
            }

        }

        startActivity(intent)

    }
}

