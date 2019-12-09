import kotlin.math.abs

private const val DAY_OF_MONTH = "03"

data class Point(val x: Int, val y: Int) {
    fun getDistanceToCenter() = abs(-x) + abs(-y)
}

data class Move(val direction: String, val distance: Int) {
    companion object {
        fun fromString(moveAsString: String): Move? {
            val regex = "(^[UDLR])([0-9].*)".toRegex()
            val matches = regex.find(moveAsString)
            return if (matches != null) Move(matches.groupValues[1], matches.groupValues[2].toInt())
            else null
        }
    }
}

val start = Point(0, 0)

val fstWireDirectionsList = ArrayList<Move>(getInputLine(DAY_OF_MONTH, 0).split(",").map { Move.fromString(it) })
val sndWireDirectionsList = ArrayList<Move>(getInputLine(DAY_OF_MONTH, 1).split(",").map { Move.fromString(it) })

fun main() {
    val fstPath = computePathForDirections(fstWireDirectionsList)
    val sndPath = computePathForDirections(sndWireDirectionsList)

    val sharedPoints = fstPath.intersect(sndPath).toHashSet()

    println(computeClosestSharedPoint(sharedPoints).getDistanceToCenter())
}

fun computePathForDirections(directions: ArrayList<Move>): HashSet<Point> {
    val coordinates = arrayListOf(start)
    directions.forEach { coordinates.addAll(computePathForMove(coordinates.last(), it)) }
    return coordinates.toHashSet()
}

fun computePathForMove(start: Point, move: Move): ArrayList<Point> {
    val passedCoordinates = ArrayList<Point>()
    val (x, y) = with(start) { arrayOf(x, y) }
    for (i in 1 until move.distance + 1) {
        when (move.direction) {
            "R" -> passedCoordinates.add(Point(x + i, y))
            "L" -> passedCoordinates.add(Point(x - i, y))
            "U" -> passedCoordinates.add(Point(x, y + i))
            "D" -> passedCoordinates.add(Point(x, y - i))
        }
    }
    return passedCoordinates
}

fun computeClosestSharedPoint(sharedPoints: HashSet<Point>): Point {
    sharedPoints.remove(start)
    return sharedPoints.minBy { it.getDistanceToCenter() }!!
}