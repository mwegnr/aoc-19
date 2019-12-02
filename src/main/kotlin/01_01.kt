private const val DAY_OF_MONTH = "01"

fun main(){
    val input = getInput(DAY_OF_MONTH)
    var sum = 0
    input.forEach { inputLine -> sum += getFuelForUnit(inputLine.toInt()) }
    print(sum)
}


fun getFuelForUnit(mass: Int): Int {
    return mass / 3 - 2
}
