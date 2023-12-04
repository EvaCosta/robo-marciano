package robo

open class RobotAdvanced : RobotAbstract() {
    open fun respond(operationType: OperationType, vararg operands: Double): String {
        val operation = OperationFactory.createOperation(operationType)
        val result = performOperation(operation, operands)
        return "Eu sei! O resultado é: $result"
    }

    private fun performOperation(operation: Operation, operands: DoubleArray): Double {
        if (operands.isEmpty()) {
            throw IllegalArgumentException("Pelo menos dois operandos são necessários para realizar a operação.")
        }

        var result = operands[0]
        for (i in 1 until operands.size) {
            result = operation.calculate(result, operands[i])
        }
        return result
    }
}