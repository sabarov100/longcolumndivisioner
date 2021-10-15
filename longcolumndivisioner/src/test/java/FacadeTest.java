import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

class FacadeTest {
     
    @Before
    private static Facade setUp() {
        return  new Facade();
    }
    
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
            + "      245";
    
    
    private static String WITHOUT_REMAINDER_EXPECTED = ""
            + "_405022500|45\n"
            + " 405      |-------\n"
            + " ---      |9000500\n"
            + "    _225\n"
            + "     225\n"
            + "     ---\n"
            + "         0\n";
     
    @Test
     void testWithRemainderLongColumnDivision() {
         assertEquals(WITH_REMAINDER_EXPECTED_ONE, setUp().columnDivision(78945, 4));
         assertEquals(WITH_REMAINDER_EXPECTED_TWO, setUp().columnDivision(234142355, 453));

    }
    
    @Test
    void testWithoutRemainderLongColumnDivision() {
        assertEquals(WITHOUT_REMAINDER_EXPECTED, setUp().columnDivision(405022500, 45));
       
   }
}