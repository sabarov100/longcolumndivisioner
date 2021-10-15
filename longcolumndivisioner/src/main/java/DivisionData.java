import java.util.List;

public class DivisionData {
    
    private int divident;
    private int divisor;
    private Calculator calculator;
    private List<Integer> division;
    
    public DivisionData(int divident, int divisor, List<Integer> division) {
        super();
        this.setDivident(divident);
        this.setDivisor(divisor);
        this.setDivision(division);
    }

    public int getDivident() {
        return divident;
    }

    public void setDivident(int divident) {
        this.divident = divident;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public List<Integer> getDivision() {
        return division;
    }

    public void setDivision(List<Integer> division) {
        this.division = new Calculator().divide(divident, divisor);
    }
    
}
