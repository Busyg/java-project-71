package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    private static final int NOCHANGE_TABULATION = 4;
    private static final int CHANGED_TABULATION = 2;

    public static String stylishFormatter(List<Map<String, Object>> parsedMapList) {
        var resultString = "{\n";
        for (var element : parsedMapList) {
            switch (element.get("status").toString()) {
                case "noChange":
                    resultString += " ".repeat(NOCHANGE_TABULATION) + element.get("key");
                    resultString += ": ";
                    resultString += element.get("oldValue");
                    resultString += "\n";
                    break;
                case "changed":
                    resultString += " ".repeat(CHANGED_TABULATION) + "- " + element.get("key");
                    resultString += ": ";
                    resultString += element.get("oldValue");
                    resultString += "\n";
                    resultString += " ".repeat(CHANGED_TABULATION) + "+ " + element.get("key");
                    resultString += ": ";
                    resultString += element.get("newValue");
                    resultString += "\n";
                    break;
                case "removed":
                    resultString += " ".repeat(CHANGED_TABULATION) + "- " + element.get("key");
                    resultString += ": ";
                    resultString += element.get("oldValue");
                    resultString += "\n";
                    break;
                case "added":
                    resultString += " ".repeat(CHANGED_TABULATION) + "+ " + element.get("key");
                    resultString += ": ";
                    resultString += element.get("newValue");
                    resultString += "\n";
                    break;
                default:
                    break;
            }
        }
        resultString += "}";
        return resultString;
    }
}
