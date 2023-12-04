package com.evacosta.robomarciano

import robo.MarcianoPremiumRobot
import robo.UserAction

object Utils {
    fun obterResposta(message: String): String {
        val userAction = object : UserAction {
            override fun performAction():String {
                return "Definição de programador: A pessoa que resolve um problema que você nem sabe que tem , de uma forma que você não entende!"
            }
        }
        val robot = MarcianoPremiumRobot(userAction)

        return if (message.equals("agir", ignoreCase = true)) {
            "É pra já! ${userAction.performAction()}"
        } else {
            robot.respond(message)
        }
    }
}