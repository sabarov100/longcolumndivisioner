import java.util.ArrayList;
import java.util.List;

public class Calculator {
        
    private static final String EMPTY = "";
    private static final String EXCEPTION_MESSAGE = "Divisor cannot be 0, division by zero";
    private static final String IA_EXCEPTION_MESSAGE_ONE = ""
            + "The dividend the number must be in the range from 0 to 2_147_483_647";
    private static final String IA_EXCEPTION_MESSAGE_TWO = ""
            + "The divisor the number must be in the range from 1 to 2_147_483_647";
    
    public List<Integer> divide(int dividend, int divisor) {
        checkDivisionArguments(dividend, divisor);
        if (Math.abs(dividend) < Math.abs(divisor)) {
            return checkArgumentsOfDivision(dividend, divisor);
        }
        List<Integer> divisionResult = new ArrayList<>();  
        StringBuilder reminder = new StringBuilder();
        String[] digits = String.valueOf(dividend).split(EMPTY);

        for (int i = 0; i < digits.length; i++) {
            reminder.append(digits[i]);
            Integer reminderNumber = Integer.parseInt(reminder.toString());

            if (reminderNumber >= divisor) {
                Integer multiplyResult = reminderNumber / divisor * divisor;
                Integer mod = reminderNumber % divisor;
                divisionResult.add(reminderNumber);
                divisionResult.add(multiplyResult);
                reminder.replace(0, reminder.length(), mod.toString());
            } else {
                if (reminderNumber == 0) {
                    divisionResult.add(reminderNumber);
                    divisionResult.add(0);
                }
            }
            if (i == digits.length - 1) {
                Integer reminderOfDivision = reminderNumber - (reminderNumber / divisor * divisor);
                divisionResult.add(reminderOfDivision);
            }
        }
        return divisionResult;
    }
    
    private void checkDivisionArguments(int divident, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        } else if(divident < 0 || divident > 2_147_483_647) {
            throw new IllegalArgumentException(IA_EXCEPTION_MESSAGE_ONE);
        } else if(divisor < 1 || divisor > 2_147_483_647) {
            throw new IllegalArgumentException(IA_EXCEPTION_MESSAGE_TWO);
        }
    }
    
    private List checkArgumentsOfDivision(int dividend, int divisor) {
        List<Integer> divisionResult = new ArrayList<>();     
            divisionResult.add(0);
            divisionResult.add(0);
            divisionResult.add(0);
            divisionResult.add(0);
            return divisionResult;
        }
}
