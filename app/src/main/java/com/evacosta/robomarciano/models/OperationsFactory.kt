package robo

object OperationFactory {
    fun createOperation(operationType: OperationType): Operation {
        return when (operationType) {
            OperationType.ADD -> AdditionOperation()
            OperationType.SUBTRACT -> SubtractionOperation()
            OperationType.MULTIPLY -> MultiplicationOperation()
            OperationType.DIVIDE -> DivisionOperation()
        }
    }
}