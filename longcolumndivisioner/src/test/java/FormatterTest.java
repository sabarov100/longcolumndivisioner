import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class FormatterTest {
    

    private static String WITH_REMAINDER_EXPECTED_ONE = ""
            + "_78945|4\n"
            + " 4    |-----\n"
            + " -    |19736\n"
            + "_38\n"
            + " 36\n"
            + " --\n"
            + " _29\n"
            + "  28\n"
            + "  --\n"
            + "  _14\n"
            + "   12\n"
            + "   --\n"
            + "   _25\n"
            + "    24\n"
            + "    --\n"
            + "     1\n";
    
    private static String WITH_REMAINDER_EXPECTED_TWO = ""
            + "_234142355|453\n"
            + " 2265     |------\n"
            + " ----     |516870\n"
            + " _764\n"
            + "  453\n"
            + "  ---\n"
            + "  _3112\n"
            + "   2718\n"
            + "   ----\n"
            + "   _3943\n"
            + "    3624\n"
            + "    ----\n"
            + "    _3195\n"
            + "     3171\n"
            + "     ----\n"
            + "      245\n";
    
    
    private static String WITHOUT_REMAINDER_EXPECTED = ""
            + "_405022500|45\n"
            + " 405      |-------\n"
            + " ---      |9000500\n"
            + "    _225\n"
            + "     225\n"
            + "     ---\n"
            + "         0\n";
    
    @Before
    private String instance(int divident, int divisor) {
        Calculator calculator = new Calculator();
        DivisionData divisionData = new DivisionData(divident, divisor, calculator.divide(divident, divisor));
        Formatter formatter =  new Formatter();
        return formatter.formatColumnDivision(divisionData);
    }
     
    @Test
     void testWithRemainderformatColumnDivision() {
         assertEquals(WITH_REMAINDER_EXPECTED_ONE, instance(78945, 4));
         assertEquals(WITH_REMAINDER_EXPECTED_TWO, instance(234142355, 453));

    }
    
    @Test
    void testWithoutRemainderformatColumnDivision() {
        assertEquals(WITHOUT_REMAINDER_EXPECTED, instance(405022500, 45));
       
   }
    
    @Test
    void testTwrowsIllegalArgumentExceptionformatColumnDivision() {
        assertThrows(IllegalArgumentException.class, () -> instance(234142355, 0));
        
    }
}
