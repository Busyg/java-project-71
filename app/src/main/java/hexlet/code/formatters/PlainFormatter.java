package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormatter(Map<Object, Map<String, Object[]>> parsedMap) {
        var resultString = "";
        for (var key : parsedMap.entrySet()) {
            for (var entry : key.getValue().entrySet()) {
                switch (entry.getKey()) {
                    case "changed":
                        resultString += "\nProperty '" + key.getKey() + "' was updated. ";
                        resultString += "From " + getPlainData(entry.getValue()[0]);
                        resultString += " to " + getPlainData(entry.getValue()[1]);
                        break;
                    case "removed":
                        resultString += "\nProperty '" + key.getKey() + "' was removed.";
                        break;
                    case "added":
                        resultString += "\nProperty '" + key.getKey() + "' was added ";
                        resultString += "with value: " + getPlainData(entry.getValue()[0]);
                        break;
                    default:
                        break;
                }
            }
        }
        return resultString.trim();
    }

    public static String getPlainData(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof ArrayList<?> || data instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return data.toString();
        }
    }
}
