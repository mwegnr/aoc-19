private const val DAY_OF_MONTH = "02"

fun main() {
    val input = getInputLine(DAY_OF_MONTH, 0)
    val instructionsAsIntList = ArrayList(input.split(",").map { it.toInt() })
    instructionsAsIntList[1] = 12
    instructionsAsIntList[2] = 2

    print(followInstructionsAndGetResult(instructionsAsIntList))
}

fun followInstructionsAndGetResult(instructions: ArrayList<Int>): Int {
    for (i in 0 until instructions.size step 4) {
        if (instructions[i] == 99) return instructions[0]
        val (fstPos, sndPos, resPos) = arrayOf(instructions[i + 1], instructions[i + 2], instructions[i + 3])
        when (instructions[i]) {
            1 -> instructions[resPos] = instructions[fstPos] + instructions[sndPos]
            2 -> instructions[resPos] = instructions[fstPos] * instructions[sndPos]
        }
    }
    return instructions[0]
}
