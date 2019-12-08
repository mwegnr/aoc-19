// TODO: doesn't work, would have been too simple

fun main() {
    sharedPoints.remove(start)
    val minStepCountPoint = computeMinDistancePoint(sharedPoints, fstPath, sndPath)
}

fun getMinCombinedDistance(point: Point,
                           fstPath: HashSet<Point>,
                           sndPath: HashSet<Point>): Int =
        fstPath.indexOf(point) + sndPath.indexOf(point)

fun computeMinDistancePoint(sharedPoints: HashSet<Point>,
                            fstPath: HashSet<Point>,
                            sndPath: HashSet<Point>): Point =
        sharedPoints.minBy { getStepCount(it, fstPath) + getStepCount(it, sndPath) }!!


fun getStepCount(point: Point, path: HashSet<Point>): Int = path.indexOf(point)