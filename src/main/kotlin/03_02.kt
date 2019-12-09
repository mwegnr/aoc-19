fun main() {
    val fstPath = computePathForDirectionsWithSteps(fstWireDirectionsList)
    val sndPath = computePathForDirectionsWithSteps(sndWireDirectionsList)

    val sharedPoints = fstPath.values.intersect(sndPath.values)
    val sharedPointsInFstPath = HashMap(fstPath.filter { entry -> entry.value != start && sharedPoints.contains(entry.value) })
    val sharedPointsInSndPath = HashMap(sndPath.filter { entry -> entry.value != start && sharedPoints.contains(entry.value) })
    val minSteps = sharedPoints.minBy { getKeyByValue(it, sharedPointsInFstPath) + getKeyByValue(it, sharedPointsInSndPath) }
    print(minSteps)
}

fun computePathForDirectionsWithSteps(directions: ArrayList<Move>): HashMap<Int, Point> {
    val passedPoints = HashMap<Int, Point>()
    passedPoints[0] = start
    directions.forEach { passedPoints.putAll(computePathForMoveWithSteps(passedPoints.values.last(), passedPoints.keys.last(), it)) }
    return passedPoints
}

fun computePathForMoveWithSteps(start: Point, steps: Int, move: Move): HashMap<Int, Point> {
    val passedCoordinates = HashMap<Int, Point>()
    val (x, y) = with(start) { arrayOf(x, y) }
    for (i in 1 until move.distance + 1) {
        passedCoordinates[steps + i] = when (move.direction) {
            "R" -> Point(x + i, y)
            "L" -> Point(x - i, y)
            "U" -> Point(x, y + i)
            else -> Point(x, y - i)
        }
    }
    return passedCoordinates
}

fun getKeyByValue(value: Point, map: HashMap<Int, Point>): Int =
        map.filter { entry -> entry.value == value }.keys.first()
