package robo

open class RobotAbstract {
    fun respond(input: String): String {
        if (isEmpty(input)) {
            return "Não me incomode"
        }

        if (Regex("(?i)eu").containsMatchIn(input)) {
            return "A responsabilidade é sua."
        }

        if (contains(input, "?")) {
            if (containsUppercaseWord(input)) {
                return "Relaxa, eu sei o que estou fazendo"
            } else {
                return "Certamente"
            }
        }

        if (containsUppercaseWord(input)) {
            return "Opa! Calma aí!"
        } else {
            return "Tudo bem como quiser"
        }
    }
    
    private fun containsUppercaseWord(input: String): Boolean {
        val words = input.split("\\s+".toRegex()) // Dividir a string em palavras
        return words.any { it.matches(Regex("^[A-Z]+[?]*\$")) }
    }

    private fun isEmpty(input: String): Boolean {
        return input.isEmpty()
    }

    private fun contains(input: String, target: String): Boolean {
        return target in input
    }

    private fun containsUppercase(input: String): Boolean {
        return input.any { it.isUpperCase() }
    }
}