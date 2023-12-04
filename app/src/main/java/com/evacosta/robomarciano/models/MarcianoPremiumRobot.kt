package robo

open class MarcianoPremiumRobot(private val userAction: UserAction) : RobotAdvanced() {
    fun respond(input: String, action: () -> Unit): String {
        if (input.equals("agir", ignoreCase = true)) {
            action()
            return "É pra já!"
        }
        return super.respond(input)
    }
}