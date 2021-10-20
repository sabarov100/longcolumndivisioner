import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class DivisionDataTest {

   
    @Test
    void testChecDivisionData() {
        DivisionData divisionDataActual = new DivisionData(234142355, 235, Calculator.divide(234142355, 235));
        DivisionData divisionDataExpected = new DivisionData(234142355, 235, new ArrayList(Arrays.asList(2341, 2115, 2264, 2115, 1492, 1410, 823, 705, 1185, 1175, 105)));
       
        assertEquals(divisionDataExpected.toString(), divisionDataActual.toString());
    }
    
    @Test
    void testTwrowsIllegalArgumentExceptionDivisionData() {
        assertThrows(IllegalArgumentException.class, () -> new DivisionData(234142355, 0, Calculator.divide(234142355, 0)));
        
    }
      
}
