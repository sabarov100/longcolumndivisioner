public class Facade {
    
    private Calculator calculator;
    private DivisionData divisionData;
    private Formatter formatter;
    
    public String columnDivision(int divident, int divisor) {
        calculator = new Calculator();
        divisionData = new DivisionData(divident, divisor, calculator.divide(divident, divisor));
        formatter = new Formatter();
        return formatter.integerColumnDivision(divisionData);
    }

}
