package hexlet.code.formatters;

import java.util.Map;

public class StylishFormatter {

    private static final int NOCHANGE_TABULATION = 4;
    private static final int CHANGED_TABULATION = 2;

    public static String stylishFormatter(Map<Object, Map<String, Object[]>> parsedMap) {
        var resultString = "{\n";
        for (var key : parsedMap.entrySet()) {
            for (var entry : key.getValue().entrySet()) {
                switch (entry.getKey()) {
                    case "noChange":
                        resultString += " ".repeat(NOCHANGE_TABULATION) + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        break;
                    case "changed":
                        resultString += " ".repeat(CHANGED_TABULATION) + "- " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        resultString += " ".repeat(CHANGED_TABULATION) + "+ " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[1];
                        resultString += "\n";
                        break;
                    case "removed":
                        resultString += " ".repeat(CHANGED_TABULATION) + "- " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        break;
                    case "added":
                        resultString += " ".repeat(CHANGED_TABULATION) + "+ " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        break;
                    default:
                        break;
                }
            }
        }
        resultString += "}";
        return resultString;
    }
}
