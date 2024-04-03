package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    public static String plainFormatter(List<Map<String, Object>> parsedMapList) {
        var resultString = "";
        for (var element : parsedMapList) {
            switch (element.get("status").toString()) {
                case "changed":
                    resultString += "\nProperty '" + element.get("key") + "' was updated. ";
                    resultString += "From " + getPlainData(element.get("oldValue"));
                    resultString += " to " + getPlainData(element.get("newValue"));
                    break;
                case "removed":
                    resultString += "\nProperty '" + element.get("key") + "' was removed";
                    break;
                case "added":
                    resultString += "\nProperty '" + element.get("key") + "' was added ";
                    resultString += "with value: " + getPlainData(element.get("newValue"));
                    break;
                default:
                    break;
            }
        }
        return resultString.trim();
    }

    public static String getPlainData(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof ArrayList<?> || data instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data.toString() + "'";
        } else {
            return data.toString();
        }
    }
}
