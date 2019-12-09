import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DayFourTest {

    @Test
    fun isIncreasingTest() {
        assertFalse(isDecreasing(111111))
        assertFalse(isDecreasing(123456))
        assertFalse(isDecreasing(145689))
        assertFalse(isDecreasing(112233))
        assertTrue(isDecreasing(223450))
        assertTrue(isDecreasing(123546))
        assertTrue(isDecreasing(112323))
        assertTrue(isDecreasing(654321))
    }

    @Test
    fun hasAdjacentDuplicateTest() {
        assertFalse(hasAdjacentDuplicate(123456))
        assertFalse(hasAdjacentDuplicate(145689))
        assertFalse(hasAdjacentDuplicate(121212))
        assertFalse(hasAdjacentDuplicate(123123))
        assertTrue(hasAdjacentDuplicate(112323))
        assertTrue(hasAdjacentDuplicate(223450))
        assertTrue(hasAdjacentDuplicate(112233))
        assertTrue(hasAdjacentDuplicate(112323))
    }

    @Test
    fun getNumberAsArrayTest() {
        assertEquals(arrayListOf(1, 2, 3, 4, 5, 6), getNumberAsArray(123456))
        assertEquals(arrayListOf(1, 2, 1, 2, 1, 2), getNumberAsArray(121212))
        assertEquals(arrayListOf(2, 2, 3, 4, 5, 0), getNumberAsArray(223450))
        assertEquals(arrayListOf(1, 4, 5, 6, 8, 9), getNumberAsArray(145689))
    }
}