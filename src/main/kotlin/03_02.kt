// TODO: doesn't work, would have been too simple

fun main() {
    sharedPoints.remove(start)
    val minStepCountPoint = sharedPoints.minBy { getStepCount(it, fstPath) + getStepCount(it, sndPath) }!!
    print(getStepCount(minStepCountPoint, fstPath) + getStepCount(minStepCountPoint, sndPath))
}

fun getStepCount(point: Point, path: HashSet<Point>): Int = path.indexOf(point)