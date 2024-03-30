package hexlet.code.formatters;

import java.lang.reflect.Array;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormatter(Map<Object, Map<String, Object[]>> parsedMap) {
        var resultString = "";
        for (var key : parsedMap.entrySet()) {
            for (var entry : key.getValue().entrySet()) {
                switch (entry.getKey()) {
                    case "changed":
                        resultString += "Property '" + key.getKey() + "' was updated. ";
                        resultString += "From " + getPlainData(entry.getValue()[0]);
                        resultString += " to " + getPlainData(entry.getValue()[1]);
                        resultString += "\n";
                        break;
                    case "removed":
                        resultString += "Property '" + key.getKey() + "' was removed.";
                        resultString += "\n";
                        break;
                    case "added":
                        resultString += "Property '" + key.getKey() + "' was added ";
                        resultString += "with value: " + getPlainData(entry.getValue()[0]);
                        resultString += "\n";
                        break;
                    default:
                        break;
                }
            }
        }
        return resultString;
    }

    public static String getPlainData(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof Array || data instanceof Map<?, ?>) {
            return "[complex value]";
        } else {
            return data.toString();
        }
    }
}
