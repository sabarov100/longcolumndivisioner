import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class CalculatorTest {
    
    private static String WITH_REMAINDER_EXPECTED_ONE = "[2341, 2115, 2264, 2115, 1492, 1410, 823, 705, 1185, 1175, 105]";
    private static String WITH_REMAINDER_EXPECTED_TWO = "[7, 4, 38, 36, 29, 28, 14, 12, 25, 24, 1]";
    private static String WITHOUT_REMAINDER_EXPECTED = "[405, 405, 0, 0, 225, 225, 0, 0, 0, 0, 0]";     
    private static String EQUALING_EXPECTED = "[45, 45, 0]";     
    private static String DIVISIBLE_IS_GREATER_THAN_DIVISOR_EXPECTED = "[0, 0, 0, 0]";     
    private static String DIVISIBLE_EQUALS_ZERO_EXPECTED = "[0, 0, 0, 0]";     

    @Before
    private static Calculator instance() {
        return new Calculator();
    }

    @Test
    void testWithRemainderOneDivide() throws IOException {
        assertEquals(WITH_REMAINDER_EXPECTED_ONE, instance().divide(234142355, 235).toString());
    }
    
    @Test
    void testWithRemainderTwoDivide() throws IOException {
        assertEquals(WITH_REMAINDER_EXPECTED_TWO, instance().divide(78945, 4).toString());
    }
    
    @Test
    void testWithoutRemainderDivide() throws IOException {
        assertEquals(WITHOUT_REMAINDER_EXPECTED, instance().divide(405022500, 45).toString());
    }
    
    @Test
    void testEqalingDivide() throws IOException {
        assertEquals(EQUALING_EXPECTED, instance().divide(45, 45).toString());
    }
    
    @Test
    void testDivisibleIsGreaterThanDivisorDivide() throws IOException {
        assertEquals(DIVISIBLE_IS_GREATER_THAN_DIVISOR_EXPECTED, instance().divide(4, 45).toString());
    }
    
    @Test
    void testDivisibleEqualsZeroDivide() throws IOException {
        assertEquals(DIVISIBLE_EQUALS_ZERO_EXPECTED, instance().divide(0, 45).toString());
    }
 
    @Test
    void testTwrowsIllegalArgumentExceptionLongColumnDivision() {
        assertThrows(IllegalArgumentException.class, () -> instance().divide(78945, 0).toString());
    }

}
