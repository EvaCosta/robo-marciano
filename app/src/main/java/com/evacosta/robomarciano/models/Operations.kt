package robo

class AdditionOperation : Operation {
    override fun calculate(operand1: Double, operand2: Double): Double {
        return operand1 + operand2
    }
}

class SubtractionOperation : Operation {
    override fun calculate(operand1: Double, operand2: Double): Double {
        return operand1 - operand2
    }
}

class MultiplicationOperation : Operation {
    override fun calculate(operand1: Double, operand2: Double): Double {
        return operand1 * operand2
    }
}

class DivisionOperation : Operation {
    override fun calculate(operand1: Double, operand2: Double): Double {
        if (operand2 == 0.0) {
            throw ArithmeticException("Divisão por zero não é permitida")
        }
        return operand1 / operand2
    }
}