import java.util.List;

public class Facade {
    
    private Calculator calculator;
    private DivisionData divisionData;
    private Formatter formatter;
    
    public void printColumnDivision(int divident, int divisor) {
        System.out.println(columnDivision(divident, divisor));
    }
    
    public String columnDivision(int divident, int divisor) {
        calculator = new Calculator();
        divisionData = new DivisionData(divident, divisor, calculator.divide(divident, divisor));
        formatter = new Formatter();
        return formatter.integerColumnDivision(divisionData);
    }

}
