private const val DAY_OF_MONTH = "02"

fun main() {
    val input = getInputLine(DAY_OF_MONTH, 0)
    print(followInstructionsAndGetResult(getInstructionsAsIntList(input)))
}

fun getInstructionsAsIntList(instructions: String): ArrayList<Int> {
    val instructionsAsIntList = ArrayList<Int>()
    instructions.split(",").forEach { it -> instructionsAsIntList.add(it.toInt()) }
    return instructionsAsIntList
}

fun followInstructionsAndGetResult(instructions: ArrayList<Int>): ArrayList<Int> {
    val firstOperandRegisterOffset = 1
    val secondOperandRegisterOffset = 2
    val resultRegisterOffset = 3

    for (i in 0 until instructions.size step 4) {
        when (instructions[i]) {
            1 -> {
                val fstValuePos = instructions[i + firstOperandRegisterOffset]
                val sndValuePos = instructions[i + secondOperandRegisterOffset]
                val resultPosition = instructions[i + resultRegisterOffset]
                instructions[resultPosition] = instructions[fstValuePos] + instructions[sndValuePos]
            }
            2 -> {
                val fstValuePos = instructions[i + 1]
                val sndValuePos = instructions[i + 2]
                val resultPosition = instructions[i + 3]
                instructions[resultPosition] = instructions[fstValuePos] * instructions[sndValuePos]
            }
            99 -> return instructions
        }
    }
    return instructions
}
