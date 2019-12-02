import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DayOneTest {
    @Test
    fun getFuelForUnitTest() {
        assertEquals(2, getFuelForUnit(12))
        assertEquals(2, getFuelForUnit(14))
        assertEquals(654, getFuelForUnit(1969))
        assertEquals(33583, getFuelForUnit(100756))
    }

    @Test
    fun getFuelForTotalMassTest() {
        assertEquals(2, getFuelForTotalMass(14))
        assertEquals(966, getFuelForTotalMass(1969))
        assertEquals(50346, getFuelForTotalMass(100756))
    }

}