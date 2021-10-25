
public class Formatter {
    
    private static final String SPACE = " ";
    private static final String DACH = "-";
    private static final String UNDERSCORE = "_";
    private static final String NEW_LINE = "\n";
    private static final String VERTICAL_LINE = "|";
    private static final String FORMAT_SYMBOL = "%s";
    private static final String ZERO = "0";
    
    public String formatColumnDivision(DivisionData divisionData) {
        int indexSpace = Math.abs(String.valueOf(divisionData.getDivision().get(1)).length() 
                - String.valueOf(divisionData.getDivision().get(2)).length());
        if(String.valueOf(divisionData.getDivisor()).length() == 1) indexSpace = 0;
        StringBuilder result = new StringBuilder();
        result.append(headerOfColumn(divisionData));
        for (int i = 2; i < divisionData.getDivision().size(); i++) {
            if (divisionData.getDivision().get(i) == 0 && i % 2 != 0) {
                indexSpace++;
                continue; 
            } else if (divisionData.getDivision().get(i) == 0 && i % 2 == 0) {
                indexSpace++;
                continue;
            }
            result.append(spaces(indexSpace));  
            if (i % 2 == 0) {
                indexSpace++;
                if (i != divisionData.getDivision().size() - 1) result.append(UNDERSCORE).append(divisionData.getDivision().get(i)).append(NEW_LINE); 
                else result.append(SPACE).append(divisionData.getDivision().get(i)).append(NEW_LINE);            
            } else {
                 result.append(divisionData.getDivision().get(i)).append(NEW_LINE);
                 result.append(spaces(indexSpace)).append(dashs(String.valueOf(divisionData.getDivision().get(i)).length ())).append(NEW_LINE);        
            }
        }       
        if (divisionData.getDivision().get(divisionData.getDivision().size() - 1) == 0) {
            result.append(spaces(String.valueOf(divisionData.getDivident()).length())).append(ZERO).append(NEW_LINE); 
        }       
        return result.toString(); 
    }
    
    private String headerOfColumn(DivisionData divisionData) {
        StringBuilder resultHeader = new StringBuilder();
        String firstLine = String.format(UNDERSCORE + FORMAT_SYMBOL + VERTICAL_LINE + FORMAT_SYMBOL + NEW_LINE,
                divisionData.getDivident(), divisionData.getDivisor());
        String space = spaces(String.valueOf(divisionData.getDivident()).length() 
                - String.valueOf(divisionData.getDivision().get(1)).length());
        String dash = dashs(String.valueOf(divisionData.getDivident() / divisionData.getDivisor()).length());
        String secondLine = String.format(SPACE + FORMAT_SYMBOL 
                + space + VERTICAL_LINE + dash + NEW_LINE, divisionData.getDivision().get(1));
        String thirdLine = String.format(SPACE + FORMAT_SYMBOL + space + VERTICAL_LINE + FORMAT_SYMBOL + NEW_LINE, 
                dashs(String.valueOf(divisionData.getDivision().get(1)).length()), 
                (divisionData.getDivident() / divisionData.getDivisor()));
        resultHeader.append(firstLine).append(secondLine).append(thirdLine);
        return resultHeader.toString();
    }
    
    private String spaces(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(SPACE);
        }
        return sb.toString();
    }

    private String dashs(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(DACH);
        }
        return sb.toString();
    }
}
