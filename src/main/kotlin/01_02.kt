private const val DAY_OF_MONTH = "01"

fun main() {
    val input = getInput(DAY_OF_MONTH)
    var sum = 0
    input.forEach { inputLine -> sum += getFuelForTotalMass(inputLine.toInt()) }
    print(sum)
}


fun getFuelForTotalMass(mass: Int): Int {
    return if (mass / 3 - 2 <= 0) 0
    else {
        val fuel = mass / 3 - 2
        fuel + (getFuelForTotalMass(fuel))
    }
}
