import java.util.ArrayList;
import java.util.List;

public class Calculator {
    
    private static final String EMPTY = "";
    private static final String EXCEPTION_MESSAGE = "Divisor cannot be 0, division by zero";

    public List<Integer> divide(int dividend, int divisor) {

        List<Integer> divisionResult = new ArrayList<>();
        
        if (divisor == 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (dividend < divisor) {
            divisionResult.add(0);
            divisionResult.add(0);
            divisionResult.add(0);
            divisionResult.add(0);
            return divisionResult;
        }

        
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
}
