package hexlet.code.formatters;

import java.util.Map;

public class StylishFormatter {
    public static String stylishFormatter(Map<Object, Map<String, Object[]>> parsedMap) {
        var resultString = "{\n";
        for (var key : parsedMap.entrySet()) {
            for (var entry : key.getValue().entrySet()) {
                switch (entry.getKey()) {
                    case "noChange":
                        resultString += " ".repeat(4) + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        break;
                    case "changed":
                        resultString += " ".repeat(2) + "- " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        resultString += " ".repeat(2) + "+ " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[1];
                        resultString += "\n";
                        break;
                    case "removed":
                        resultString += " ".repeat(2) + "- " + key.getKey();
                        resultString += ": ";
                        resultString += entry.getValue()[0];
                        resultString += "\n";
                        break;
                    case "added":
                        resultString += " ".repeat(2) + "+ " + key.getKey();
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
