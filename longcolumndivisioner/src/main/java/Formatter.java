
public class Formatter {
    
    private DivisionData divisionData;
    
    public String integerColumnDivision(DivisionData divisionData) {
        
        int str = Math.abs(String.valueOf(divisionData.getDivision().get(1)).length() - String.valueOf(divisionData.getDivision().get(2)).length());
        if(String.valueOf(divisionData.getDivisor()).length() == 1) {
            str = 0;
        }
        StringBuilder result = new StringBuilder();
        result.append(hatColumn(divisionData));
        
        for (int i = 2; i < divisionData.getDivision().size(); i++) {
            if (divisionData.getDivision().get(i) == 0 && i % 2 != 0) {
                str++;
                continue; 
            } else if (divisionData.getDivision().get(i) == 0 && i % 2 == 0) {
                str++;
                continue;
            }
            result.append(spaces(str));
            
            if (i % 2 == 0) {
                str++;
                if (i != divisionData.getDivision().size() - 1) {
                    result.append("_" + divisionData.getDivision().get(i) + "\n"); 
                } else {
                    result.append(" " + divisionData.getDivision().get(i));
                }
                
            } else {
                 result.append(divisionData.getDivision().get(i) + "\n");
                 result.append(spaces(str) + dashs(String.valueOf(divisionData.getDivision().get(i)).length ()) + "\n");        
            }
          }
        
        if (divisionData.getDivision().get(divisionData.getDivision().size() - 1) == 0) {
            result.append(spaces(String.valueOf(divisionData.getDivident()).length()) + "0"); 
        }
        
        return result.toString(); 
    }
    
    private String hatColumn(DivisionData divisionData) {
        StringBuilder resultHat = new StringBuilder();
        resultHat.append(String.format("_%s|%s\n", divisionData.getDivident(), divisionData.getDivisor()));
        String space = spaces(String.valueOf(divisionData.getDivident()).length() - String.valueOf(divisionData.getDivision().get(1)).length());
        String dash = dashs(String.valueOf(divisionData.getDivident() / divisionData.getDivisor()).length());
        resultHat.append(String.format(" %s" + space + "|" + dash +"\n", divisionData.getDivision().get(1)));
        resultHat.append(String.format(" %s" + space + "|%s\n", dashs(String.valueOf(divisionData.getDivision().get(1)).length()), (divisionData.getDivident() / divisionData.getDivisor())));
        return resultHat.toString();
    }
    
    private String spaces(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String dashs(int value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
