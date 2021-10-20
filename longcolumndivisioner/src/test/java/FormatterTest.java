import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

class FormatterTest {
    
    private static String WITH_REMAINDER_EXPECTED = ""
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
    
    @Mock
    private DivisionData divisionData;
    
    @InjectMocks
    private Formatter formatter = new Formatter();

    @Test
    void test() {
        DivisionData divisionData = Mockito.mock(DivisionData.class);
        Mockito.when(divisionData).thenReturn(new DivisionData(234142355, 453, 
                new ArrayList<Integer>(Arrays.asList(2341, 2265, 764, 453, 3112, 2718, 3943, 3624, 3195, 3171, 245)))
        );
        
        String checking = formatter.integerColumnDivision(divisionData);
       
        assertEquals(WITH_REMAINDER_EXPECTED, checking);
        Mockito.verify(formatter).integerColumnDivision(divisionData);
    }

}
