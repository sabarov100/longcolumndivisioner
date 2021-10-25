import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)

class FacadeTest {
    
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
    private Calculator mockedCalculator;
    
    @Mock
    private DivisionData mockedDivisionData;
    
    @Mock
    private Formatter mockedFormatter;
    
    @InjectMocks
    private Facade facade;
    
    @Before
    private static Facade setUp() {
        return  new Facade();
    }
    
    @Test
    void testColumnDivision() {
        Calculator mockedCalculator = Mockito.mock(Calculator.class);
        DivisionData mockedDivisionData = Mockito.mock(DivisionData.class);
        Formatter mockedFormatter = Mockito.mock(Formatter.class);
        Mockito.when(mockedCalculator.divide(234142355, 234142355))
        .thenReturn(new ArrayList<Integer>(Arrays.asList(2341, 2265, 764, 453, 3112, 2718, 3943, 3624, 3195, 3171, 245)));
        mockedDivisionData = new DivisionData(234142355, 453, mockedCalculator.divide(234142355, 453));
        
        String checking = mockedFormatter.formatColumnDivision(mockedDivisionData);
        String expected = setUp().columnDivision(234142355, 453);
        assertEquals(WITH_REMAINDER_EXPECTED, checking);
        assertEquals(expected, checking);
    }
    
    @Test
    void testTwrowsIllegalArgumentExceptionColumnDivision() {
        assertThrows(IllegalArgumentException.class, () -> setUp().columnDivision(234142355, 0));
        
    }
}