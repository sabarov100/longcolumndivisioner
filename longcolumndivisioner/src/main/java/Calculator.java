import java.util.ArrayList;
import java.util.List;

public class Calculator {
    
    private static final String EMPTY = "";

    public List<Integer> divide(int dividend, int divisor) {

        StringBuilder reminder = new StringBuilder();
        List<Integer> divisionResult = new ArrayList<>();
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
