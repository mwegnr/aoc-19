import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayTwoTest {
    private val testInputAsIntList1 = arrayListOf(1, 0, 0, 0, 99)
    private val testInputAsIntList2 = arrayListOf(2, 3, 0, 3, 99)
    private val testInputAsIntList3 = arrayListOf(2, 4, 4, 5, 99, 0)
    private val testInputAsIntList4 = arrayListOf(1, 1, 1, 4, 99, 5, 6, 0, 99)


    @Test
    fun getInstructionsAsIntListTest() {
        val testInput1 = "1,0,0,0,99"
        val testInput2 = "2,3,0,3,99"
        val testInput3 = "2,4,4,5,99,0"
        val testInput4 = "1,1,1,4,99,5,6,0,99"

        assertEquals(testInputAsIntList1, getInstructionsAsIntList(testInput1))
        assertEquals(testInputAsIntList2, getInstructionsAsIntList(testInput2))
        assertEquals(testInputAsIntList3, getInstructionsAsIntList(testInput3))
        assertEquals(testInputAsIntList4, getInstructionsAsIntList(testInput4))
    }

    @Test
    fun followInstructionsTest() {
        val testOutPutAsIntList1 = arrayListOf(2, 0, 0, 0, 99)
        val testOutPutAsIntList2 = arrayListOf(2, 3, 0, 6, 99)
        val testOutPutAsIntList3 = arrayListOf(2, 4, 4, 5, 99, 9801)
        val testOutPutAsIntList4 = arrayListOf(30, 1, 1, 4, 2, 5, 6, 0, 99)

        assertEquals(testOutPutAsIntList1, followInstructionsAndGetResult(testInputAsIntList1))
        assertEquals(testOutPutAsIntList2, followInstructionsAndGetResult(testInputAsIntList2))
        assertEquals(testOutPutAsIntList3, followInstructionsAndGetResult(testInputAsIntList3))
        assertEquals(testOutPutAsIntList4, followInstructionsAndGetResult(testInputAsIntList4))
    }

}