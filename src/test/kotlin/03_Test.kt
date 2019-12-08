import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class DayThreeTest {
    private val fstWireTestInput1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72"
    private val sndWireTestInput1 = "U62,R66,U55,R34,D71,R55,D58,R83"

    private val fstWireTestInput2 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
    private val sndWireTestInput2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"

    private val testPoint1 = start
    private val testPoint2 = Point(6, 6)
    private val testPoint3 = Point(3, 4)
    private val testPoint4 = Point(12, 8)

    private val testMove1 = Move("R", 10)
    private val testMove2 = Move("U", 2)
    private val testMove3 = Move("L", 4)
    private val testMove4 = Move("D", 3)

    private val firstPath = hashSetOf(
            start, Point(1, 0),
            Point(2, 0), Point(3, 0),
            Point(4, 0), Point(5, 0),
            Point(6, 0), Point(7, 0),
            Point(8, 0), Point(9, 0),
            Point(10, 0), Point(10, 1),
            Point(10, 2), Point(9, 2),
            Point(8, 2), Point(7, 2),
            Point(6, 2), Point(6, 1),
            Point(6, 0), Point(6, -1))

    private val secondPath = hashSetOf(
            Point(0, 0), Point(0, 1),
            Point(0, 2), Point(-1, 2),
            Point(-2, 2), Point(-3, 2),
            Point(-4, 2), Point(-4, 1),
            Point(-4, 0), Point(-4, -1),
            Point(-3, -1), Point(-2, -1),
            Point(-1, -1), Point(0, -1),
            Point(1, -1), Point(2, -1),
            Point(3, -1), Point(4, -1),
            Point(5, -1), Point(6, -1))

    @Test
    fun moveFromStringTest() {
        val testString1 = "R10"
        val testString2 = "U2"
        val testString3 = "L4"
        val testString4 = "D3"
        val testString5 = "DR39"

        assertEquals(testMove1, Move.fromString(testString1))
        assertEquals(testMove2, Move.fromString(testString2))
        assertEquals(testMove3, Move.fromString(testString3))
        assertEquals(testMove4, Move.fromString(testString4))
        assertNull(Move.fromString(testString5))
    }

    @Test
    fun computePathForMoveTest() {
        val resultList1 = arrayListOf(
                Point(1, 0), Point(2, 0),
                Point(3, 0), Point(4, 0),
                Point(5, 0), Point(6, 0),
                Point(7, 0), Point(8, 0),
                Point(9, 0), Point(10, 0))
        val resultList2 = arrayListOf(
                Point(6, 7), Point(6, 8))
        val resultList3 = arrayListOf(
                Point(2, 4), Point(1, 4),
                Point(0, 4), Point(-1, 4))
        val resultList4 = arrayListOf(
                Point(12, 7), Point(12, 6),
                Point(12, 5))

        assertEquals(resultList1, computePathForMove(testPoint1, testMove1))
        assertEquals(resultList2, computePathForMove(testPoint2, testMove2))
        assertEquals(resultList3, computePathForMove(testPoint3, testMove3))
        assertEquals(resultList4, computePathForMove(testPoint4, testMove4))
    }

    @Test
    fun computePathForDirectionsTest() {
        val directionList1 = arrayListOf(testMove1, testMove2, testMove3, testMove4)
        val directionList2 = arrayListOf(testMove2, testMove3, testMove4, testMove1)

        assertEquals(firstPath, computePathForDirections(directionList1))
        assertEquals(secondPath, computePathForDirections(directionList2))
    }

    @Test
    fun fstExerciseTest() {
        val fstWireDirections1 = ArrayList<Move>(fstWireTestInput1.split(",").map { Move.fromString(it) })
        val sndWireDirections1 = ArrayList<Move>(sndWireTestInput1.split(",").map { Move.fromString(it) })

        val fstWireDirections2 = ArrayList<Move>(fstWireTestInput2.split(",").map { Move.fromString(it) })
        val sndWireDirections2 = ArrayList<Move>(sndWireTestInput2.split(",").map { Move.fromString(it) })

        val fstPath1 = computePathForDirections(fstWireDirections1)
        val sndPath1 = computePathForDirections(sndWireDirections1)

        val fstPath2 = computePathForDirections(fstWireDirections2)
        val sndPath2 = computePathForDirections(sndWireDirections2)

        assertEquals(159, computeClosestSharedPoint(fstPath1.intersect(sndPath1).toHashSet()).getDistanceToCenter())
        assertEquals(135, computeClosestSharedPoint(fstPath2.intersect(sndPath2).toHashSet()).getDistanceToCenter())
    }

    @Test
    fun sndExerciseTest() {
        val fstWireDirections1 = ArrayList<Move>(fstWireTestInput1.split(",").map { Move.fromString(it) })
        val sndWireDirections1 = ArrayList<Move>(sndWireTestInput1.split(",").map { Move.fromString(it) })

        val fstWireDirections2 = ArrayList<Move>(fstWireTestInput2.split(",").map { Move.fromString(it) })
        val sndWireDirections2 = ArrayList<Move>(sndWireTestInput2.split(",").map { Move.fromString(it) })

        val fstPath1 = computePathForDirections(fstWireDirections1)
        val sndPath1 = computePathForDirections(sndWireDirections1)

        val fstPath2 = computePathForDirections(fstWireDirections2)
        val sndPath2 = computePathForDirections(sndWireDirections2)

        val sharedPoints1 = fstPath1.intersect(sndPath1).toHashSet()
        val sharedPoints2 = fstPath2.intersect(sndPath2).toHashSet()

        sharedPoints1.remove(start)
        sharedPoints2.remove(start)

        val minDistancePoint1 = computeMinDistancePoint(sharedPoints1, fstPath1, sndPath1)
        val minDistancePoint2 = computeMinDistancePoint(sharedPoints2, fstPath2, sndPath2)

        assertEquals(610, getMinCombinedDistance(minDistancePoint1, fstPath1, sndPath1))
        assertEquals(410, getMinCombinedDistance(minDistancePoint2, fstPath2, sndPath2))
    }

    @Test
    fun getManhattanDistanceTest() {
        assertEquals(0, testPoint1.getDistanceToCenter())
        assertEquals(12, testPoint2.getDistanceToCenter())
        assertEquals(7, testPoint3.getDistanceToCenter())
        assertEquals(20, testPoint4.getDistanceToCenter())
    }
}