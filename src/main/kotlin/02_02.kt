private const val DAY_OF_MONTH = "02"

fun main() {
    val input = getInputLine(DAY_OF_MONTH, 0)
    val expectedRes = 19690720
    val instructionsAsIntList = ArrayList(input.split(",").map { it.toInt() })

    print(computeInputHash(instructionsAsIntList, expectedRes))
}

fun computeInputHash(instructions: ArrayList<Int>, expectedResult: Int): Int {
    for (noun in 0..100) {
        for (verb in 0..100) {
            val memoryCopy = ArrayList(instructions)
            memoryCopy[1] = noun
            memoryCopy[2] = verb
            if (followInstructionsAndGetResult(memoryCopy) == expectedResult) {
                return 100 * noun + verb
            }
        }
    }
    return -1
}