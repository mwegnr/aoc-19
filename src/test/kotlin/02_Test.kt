import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayTwoTest {
    private val testInputAsIntList1 = arrayListOf(1, 0, 0, 0, 99)
    private val testInputAsIntList2 = arrayListOf(2, 3, 0, 3, 99)
    private val testInputAsIntList3 = arrayListOf(2, 4, 4, 5, 99, 0)
    private val testInputAsIntList4 = arrayListOf(1, 1, 1, 4, 99, 5, 6, 0, 99)


    @Test
    fun followInstructionsTest() {
        assertEquals(2, followInstructionsAndGetResult(testInputAsIntList1))
        assertEquals(2, followInstructionsAndGetResult(testInputAsIntList2))
        assertEquals(2, followInstructionsAndGetResult(testInputAsIntList3))
        assertEquals(30, followInstructionsAndGetResult(testInputAsIntList4))
    }

    @Test
    fun determineInputTest() {
        // test is omitted because it would need at least 100 array entries
    }

}