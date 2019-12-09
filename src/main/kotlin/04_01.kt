private const val DAY_OF_MONTH = "04"

fun main() {
    val input = getInputLine(DAY_OF_MONTH, 0)
    val (start, end) = input.split('-').map { it.toInt() }
    print((start..end).toList().filter { isPasswordCandidate(it) }.size)
}

fun isPasswordCandidate(number: Int): Boolean = !isDecreasing(number) && hasAdjacentDuplicate(number)

fun isDecreasing(number: Int): Boolean {
    val numberAsIntArray = getNumberAsArray(number)
    numberAsIntArray.forEachIndexed { i, it ->
        if (i < numberAsIntArray.lastIndex && it > numberAsIntArray.subList(
                i + 1,
                numberAsIntArray.lastIndex + 1
            ).min()!!
        ) return true
    }
    return false
}

fun hasAdjacentDuplicate(number: Int): Boolean {
    val numberAsIntArray = getNumberAsArray(number)
    numberAsIntArray.forEachIndexed { i, it ->
        if (i < numberAsIntArray.lastIndex && it == numberAsIntArray[i + 1] && it != numberAsIntArray[i + 2]) return true
    }
    return false
}

fun getNumberAsArray(number: Int): ArrayList<Int> {
    val numberAsList = ArrayList<Int>()
    var numberForLoop = number
    for (i in 0..5) {
        numberAsList.add(numberForLoop.rem(10))
        numberForLoop /= 10
    }
    numberAsList.reverse()
    return numberAsList
}